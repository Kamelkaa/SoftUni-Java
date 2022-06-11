package Exercise;

import java.util.Scanner;

public class Task_01_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] allUsernames = scanner.nextLine().split(", ");

        for (String username : allUsernames) {
            boolean validUsername = isValidUsername(username);
            if (validUsername) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValidUsername(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }

        for (int i = 0; i <= username.length() - 1; i++) {
            char currentSymbol = username.charAt(i);
            if (!Character.isAlphabetic(currentSymbol) && !Character.isDigit(currentSymbol) && currentSymbol != '-' && currentSymbol != '_') {
                return false;
            }
        }
        return true;
    }
}
