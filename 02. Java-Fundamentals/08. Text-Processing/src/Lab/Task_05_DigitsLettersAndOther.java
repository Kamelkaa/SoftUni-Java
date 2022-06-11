package Lab;

import java.util.Scanner;

public class Task_05_DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (Character.isDigit(currentSymbol)) {
                digits.append(currentSymbol);
            } else if (Character.isAlphabetic(currentSymbol)) {
                letters.append(currentSymbol);
            } else {
                others.append(currentSymbol);
            }
        }

        System.out.printf("%s%n" +
                "%s%n" +
                "%s", digits, letters, others);
    }
}
