package training;


import training.models.character.Character;
import training.models.mobs.ChrisTheWheelchair;
import training.services.CharacterCreationService;

import java.util.ArrayList;
import java.util.List;

public class WowGame {
    private static final CharacterCreationService characterCreationService = new CharacterCreationService();
    private static List<Character> characters = new ArrayList<>();
    public static void main(String[] args) {
       characters = characterCreationService.createCharacter(characters);
        ChrisTheWheelchair chris = new ChrisTheWheelchair();
        System.out.println(" ");
    }
}