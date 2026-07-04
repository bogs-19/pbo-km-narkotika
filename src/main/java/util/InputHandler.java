package util;

public class InputHandler {

    public static boolean isStringValid(String input) {
        return input != null && !input.trim().isEmpty();
    }
    public static boolean isPositive(double value) {
        return value >= 0;
    }

    public static int validasiInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static double validasiDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
