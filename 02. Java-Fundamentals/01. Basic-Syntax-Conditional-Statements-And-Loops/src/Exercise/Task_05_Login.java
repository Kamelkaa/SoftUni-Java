package Exercise;

import java.util.Scanner;

public class Task_05_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        StringBuilder passwordBuilder = new StringBuilder();

        for (int i = username.length() - 1; i >= 0; i--) {
            char currentSymbol = username.charAt(i);
            passwordBuilder.append(currentSymbol);
        }

        String password = passwordBuilder.toString();
        String input = scanner.nextLine();
        int counterErrors = 0;

        while (!input.equals(password)) {
            counterErrors++;

            if (counterErrors == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scanner.nextLine();
        }

        if (input.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
