package training.services;

import lombok.NoArgsConstructor;
import training.models.character.Character;
import training.models.character.Rogue;
import training.utils.Utils;

import java.util.List;
import java.util.Scanner;

import static training.utils.Utils.errorMessage;
import static training.utils.Utils.toInteger;

@NoArgsConstructor
public class CharacterCreationService {
    private final Scanner input = new Scanner(System.in);
    private List<Character> characters;
    private String chosenName;
    private Utils.classes chosenClass;


    public List<Character> createCharacter(List<Character> characters) {
        this.characters = characters;
        System.out.println(
                "Welcome to the character creation!\n" +
                        "Please enter you character's name: ");
        this.chosenName = input.nextLine();
        do {
            System.out.println(
                    "What is " + this.chosenName + "'s class? (Enter the corresponding number)");
            int numberOfClasses = printClassesList();

            String chosenClass = input.nextLine();

            int classNumber = toInteger(chosenClass);
            if (classNumber > numberOfClasses || classNumber < numberOfClasses) {
                errorMessage();
            } else {
                this.chosenClass = Utils.classes.values()[classNumber - 1];
            }

        } while (chosenClass == null);
        createCharacterInstance();
        return characters;
    }

    private int printClassesList() {
        int counter = 0;
        for (Utils.classes className : Utils.classes.values()) {
            counter++;
            System.out.println(counter + ": " + className);
        }
        return counter;
    }

    private void createCharacterInstance() {
        String classValue = chosenClass.toString();
        switch (classValue) {
            case "ROGUE":
                characters.add(new Character(this.chosenName, new Rogue()));
        }
        System.out.println("You've just created your character: " +
                characters.get(characters.size() - 1).getName() + " the " +
                characters.get(characters.size() - 1).getAClass().getClassNameTag() + "!");

    }

}
