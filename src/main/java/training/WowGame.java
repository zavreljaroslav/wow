package training;

import training.services.GameService;

public class WowGame {
    private final static GameService gameService = new GameService();
    public static void main(String[] args) {
       gameService.playGame();
    }
}