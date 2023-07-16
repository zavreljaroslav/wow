package training;


import training.models.character.Character;
import training.models.mobs.ChrisTheWheelchair;
import training.services.CharacterCreationService;
import training.services.GameService;

import java.util.ArrayList;
import java.util.List;

public class WowGame {
    private final static GameService gameService = new GameService();
    public static void main(String[] args) {
       gameService.playGame();
    }
}