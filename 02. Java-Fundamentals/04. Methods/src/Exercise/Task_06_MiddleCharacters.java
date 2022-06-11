package Exercise;

import java.util.Scanner;

public class Task_06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        printMiddleCharacter(text);
    }

    private static void printMiddleCharacter(String text) {
        if (text.length() % 2 == 1) {
            System.out.println(text.charAt(text.length() / 2));
        } else {
            char symbolOne = text.charAt(text.length() / 2 - 1);
            char symbolTwo = text.charAt(text.length() / 2);
            System.out.printf("%c%c", symbolOne, symbolTwo);
        }
    }
}
