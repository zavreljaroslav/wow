package training.utils;

import static training.services.GameService.divideScreen;

public abstract class Utils {
    public enum classes {ROGUE}
    public enum primaryResourceType {ENERGY, RAGE, MANA};
    public static void errorMessage() {
        System.out.println("Please enter a valid number corresponding to the displayed options.");
        divideScreen();
    }
    public static int toInteger(String input){
        try {
            int response = Integer.parseInt(input);
            return response;
        } catch (Exception e) {
            errorMessage();
            return -1;
        }
    }
}
