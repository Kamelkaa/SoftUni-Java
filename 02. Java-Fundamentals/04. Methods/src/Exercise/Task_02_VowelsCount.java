package Exercise;

import java.util.Locale;
import java.util.Scanner;

public class Task_02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        printCountedVowels(text.toLowerCase());
    }

    private static void printCountedVowels(String text) {
        int counter = 0;

        for (int i = 0; i <= text.length() - 1; i++) {
            char currentChar = text.charAt(i);
            switch (currentChar) {
                case 'a':
                case 'e':
                case 'y':
                case 'u':
                case 'o':
                case 'i':
                    counter++;
                    break;
            }
        }

        System.out.println(counter);
    }
}
