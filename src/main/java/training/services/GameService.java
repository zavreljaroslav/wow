package training.services;

import training.models.character.Character;
import training.models.character.Class;
import training.models.mobs.ChrisTheWheelchair;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private List<Character> characters = new ArrayList<>();
    private List<Class> enemies = new ArrayList<>();
    private CharacterCreationService characterCreationService = new CharacterCreationService();
    private CombatService combatService = new CombatService();
    public void playGame(){
        gameStart();
        divideScreen();
        enemies.add(new ChrisTheWheelchair());
        combatService.fight(characters.get(0), enemies.get(0));

    }
    private void gameStart(){
        System.out.println("Welcome to the terminal WoW game simulator thingy!");
        divideScreen();
        if(characters.isEmpty()){
            System.out.println("It seems like you don't have any characters to play as, let's create one!");
            divideScreen();
            characterCreationService.createCharacter(characters);
        } else {
            //TODO: if there was a resume function you would go here to load your character from db/file
        }
    }
    public static void divideScreen(){
        System.out.println("-------------------------------------------------------\n");
    }
}
