package FinalExam01;

import java.util.Scanner;

public class Task_01_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] instructions = input.split("\\|");
            String command = instructions[0];

            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(instructions[1]);
                    String substringToMove = message.substring(0, numberOfLetters);

                    message = message.substring(numberOfLetters) + substringToMove;
                    break;
                case "Insert":
                    int index = Integer.parseInt(instructions[1]);
                    String value = instructions[2];

                    message = message.substring(0, index) + value + message.substring(index);
                    break;
                case "ChangeAll":
                    String oldString = instructions[1];
                    String newString = instructions[2];

                    message = message.replace(oldString, newString);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", message);
    }
}
