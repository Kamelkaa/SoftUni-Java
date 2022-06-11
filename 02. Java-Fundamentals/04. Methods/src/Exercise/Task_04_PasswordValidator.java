package Exercise;

import java.util.Scanner;

public class Task_04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean isValidLength = validateLength(password);
        boolean isValidLettersAndDigits = validateLetterAndDigits(password);
        boolean isValidDigitCount = validateDigitCount(password);

        if (!isValidLength) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!isValidLettersAndDigits) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!isValidDigitCount) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidLength && isValidLettersAndDigits && isValidDigitCount) {
            System.out.println("Password is valid");
        }
    }

    private static boolean validateLength(String pass) {
        return pass.length() >= 6 && pass.length() <= 10;
    }

    private static boolean validateLetterAndDigits(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            char currentChar = pass.charAt(i);

            boolean isSmallLetter = currentChar >= 97 && currentChar <= 122;
            boolean isCapitalLetter = currentChar >= 65 && currentChar <= 90;
            boolean isDigit = currentChar >= 48 && currentChar <= 57;

            if (!isSmallLetter && !isCapitalLetter && !isDigit) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateDigitCount(String pass) {
        int charCounter = 0;
        for (int i = 0; i < pass.length(); i++) {
            char currentChar = pass.charAt(i);
            if (Character.isDigit(currentChar)) {
                charCounter++;
            }
        }
        return charCounter >= 2;
    }
}
