package Exercise;

import java.util.Scanner;

public class Task_03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        printCharacterInRange(firstChar, secondChar);
    }

    private static void printCharacterInRange(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            for (int i = secondChar + 1; i <= firstChar - 1; i++) {
                System.out.print((char) i + " ");
            }
        } else {
            for (int i = firstChar + 1; i <= secondChar - 1; i++) {
                System.out.print((char) i + " ");
            }
        }
    }
}
