package Model;

public class ChangeBase {
    public static String convertBase(String input, int inputBase, int outputBase) {
        try {
            int decimalValue = Integer.parseInt(input, inputBase);
            return Integer.toString(decimalValue, outputBase);
        } catch (NumberFormatException e) {
            return "Invalid input for the selected base.";
        }
    }
}
