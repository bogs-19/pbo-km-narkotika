package util;

public class InputHandler {
    public static boolean isStringValid(String input) {
        return input != null && !input.trim().isEmpty();
    }
    public static boolean isPositive(double value) {
        return value >= 0;
    }
}
