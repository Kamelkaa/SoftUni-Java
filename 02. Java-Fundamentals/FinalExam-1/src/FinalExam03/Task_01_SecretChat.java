package FinalExam03;

import java.util.Scanner;

public class Task_01_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String commandsInput = scanner.nextLine();

        while (!commandsInput.contains("Reveal")) {
            String[] instructions = commandsInput.split(":\\|:");
            String command = instructions[0];

            switch (command) {
                case "InsertSpace":
                    int indexToInsert = Integer.parseInt(instructions[1]);
                    message = message.substring(0, indexToInsert) + " " + message.substring(indexToInsert);
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substringToRevers = instructions[1];
                    int indexSubstring = message.indexOf(substringToRevers);

                    if (message.contains(substringToRevers)) {
                        String newSubstring = reversedSubstring(substringToRevers);//или без метод:
                        //String newSubstring = new StringBuilder(substringToRevers).reverse().toString;
                        message = message.substring(0, indexSubstring) + message.substring(indexSubstring + substringToRevers.length());
                        message = message + newSubstring;
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String oldString = instructions[1];
                    String newString = instructions[2];

                    message = message.replace(oldString, newString);
                    System.out.println(message);
                    break;
            }

            commandsInput = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s", message);
    }

    private static String reversedSubstring(String substringToRevers) {
        StringBuilder reversedString = new StringBuilder();

        for (int i = substringToRevers.length() - 1; i >= 0; i--) {
            char currentSymbol = substringToRevers.charAt(i);
            reversedString.append(currentSymbol);
        }
        return reversedString.toString();
    }
}
