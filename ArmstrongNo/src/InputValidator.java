public class InputValidator {
    public static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }
}
