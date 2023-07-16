package training.services;

import training.models.character.Character;
import training.models.character.Class;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

import static training.services.GameService.divideScreen;
import static training.utils.Utils.errorMessage;
import static training.utils.Utils.toInteger;

public class CombatService {
    private Character character;
    private Class enemy;
    private final Scanner input;

    public CombatService() {
        input = new Scanner(System.in);
    }

    public void fight(Character character, Class enemy) {
        this.character = character;
        this.enemy = enemy;

        System.out.println("As " + character.getName() + " strolls through the forest, suddenly a wild " + enemy.getClassName() + " appears!\n" +
                "you brace yourself as combat ensues...");
        divideScreen();

        do {
            System.out.println(character);
            divideScreen();
            System.out.println(enemy);

            printFightMenu();
            divideScreen();
            enemyTurn();
            divideScreen();

            enemy.generatePrimaryResource(enemy.getPrimaryResource().getRegenPerRound());
            character.getAClass().generatePrimaryResource(character.getAClass().getPrimaryResource().getRegenPerRound());
            divideScreen();

        } while (character.getAClass().getCurrentHp() > 0 && enemy.getCurrentHp() > 0);
        if (character.getAClass().getCurrentHp() <= 0) {
            System.out.println(enemy.getClassName() + " has defeated you and you died!");
        } else {
            System.out.println("You've defeated " + enemy.getClassName() + "!");
        }
    }

    private void printFightMenu() {
        boolean endRound = false;
        divideScreen();
        do {
            System.out.println("\nYour Actions:\n" +
                    "1. Melee Attack\n" +
                    "2. Open Spellbook\n" +
                    "3. Consumables");
            String action = input.nextLine();
            int actionNumber = toInteger(action);
            if (actionNumber != -1) {
                switch (actionNumber) {
                    case 1 -> endRound = meleeAttack(character.getAClass(), enemy);
                    case 2 -> endRound = openSpellBook();
                    case 3 -> endRound = showConsumables();
                }
            }
        } while (!endRound);
    }

    private void enemyTurn() {
        Random generateRandomNumber = new Random();
        int action = 1 + generateRandomNumber.nextInt(2);
        if (action == 1) {
            meleeAttack(enemy, character.getAClass());
        } else if (action == 2) {
            useSpell(1, enemy, character.getAClass());
        }
    }

    private boolean meleeAttack(Class attacker, Class defender) {
        double damage = attacker.getBaseDamage() - defender.getBaseArmor();
        System.out.println(attacker.getClassName() + " has used melee attack!\n" +
                defender.getClassName() + " is struck for " + damage + " damage!");
        defender.setCurrentHp(defender.getCurrentHp() - damage);
        return true;
    }

    private boolean openSpellBook() {
        int spellNumber;
        do {
            System.out.println(character.getAClass().getSpellBook());
            System.out.println((character.getAClass().getSpellBook().getSpellList().size() + 1) + ". Go back");
            String chosenSpell = input.nextLine();
            spellNumber = toInteger(chosenSpell);

            if (spellNumber == character.getAClass().getSpellBook().getSpellList().size() + 1) {
                return false;
            } else if (spellNumber != -1 && spellNumber <= character.getAClass().getSpellBook().getSpellList().size()) {
                return useSpell(spellNumber, character.getAClass(), enemy);
            } else if (spellNumber != -1){
                errorMessage();
            }
        } while (spellNumber == -1);
        return false;
    }

    private boolean useSpell(int spellNumber, Class attacker, Class defender) {
        if (spellNumber != -1) {
            if (attacker.getPrimaryResource().getAmount() >= attacker.getSpellBook().getSpellList().get(spellNumber - 1).getCost()) {
                double damage = attacker.getSpellBook().getSpellList().get(spellNumber - 1).getDamage();
                System.out.println(attacker.getClassName() + " has used "
                        + attacker.getSpellBook().getSpellList().get(spellNumber - 1).getName() +
                        "\n" + defender.getClassName() + " is struck for " + damage + " damage!");

                defender.setCurrentHp(defender.getCurrentHp() - damage);
                attacker.getPrimaryResource().setAmount(attacker.getPrimaryResource().getAmount()
                        - attacker.getSpellBook().getSpellList().get(spellNumber - 1).getCost());
            } else {
                System.out.println(attacker.getClassName() + " struggles to cast the spell as a result of insufficient resources and misses the turn!");
            }
        }
        return true;
    }

    private boolean showConsumables() {
        System.out.println("You don't have any consumables! (they aren't in the game yet)");
        return false;
    }
}