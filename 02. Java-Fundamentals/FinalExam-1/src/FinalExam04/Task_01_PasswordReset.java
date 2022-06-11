package FinalExam04;

import java.util.Scanner;

public class Task_01_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String inputCommands = scanner.nextLine();

        while (!inputCommands.equals("Done")) {
            String command = inputCommands.split(" ")[0];

            switch (command) {
                case "TakeOdd":
                    password = oddCharactersOnly(password);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(inputCommands.split(" ")[1]);
                    int length = Integer.parseInt(inputCommands.split(" ")[2]);

                    password = cutSubstring(index, length, password);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String oldString = inputCommands.split(" ")[1];
                    String newString = inputCommands.split(" ")[2];

                    if (password.contains(oldString)) {
                        password = password.replace(oldString, newString);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            inputCommands = scanner.nextLine();
        }

        System.out.printf("Your password is: %s", password);
    }

    private static String oddCharactersOnly(String password) {
        StringBuilder oddCharactersOnly = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            if (i % 2 != 0) {
                oddCharactersOnly.append(currentSymbol);
            }
        }
        return oddCharactersOnly.toString();
    }

    private static String cutSubstring(int index, int length, String password) {
        String start = password.substring(0, index);
        String end = password.substring(index + length);
        return start + end;
    }
}
