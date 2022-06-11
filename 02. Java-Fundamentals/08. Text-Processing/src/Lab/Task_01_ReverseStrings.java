package Lab;

import java.util.Scanner;

public class Task_01_ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        while (!word.equals("end")) {
            StringBuilder reversedWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                char currentSymbol = word.charAt(i);
                reversedWord.append(currentSymbol);
            }

            System.out.printf("%s = %s%n", word, reversedWord);

            word = scanner.nextLine();
        }
    }
}
