package Exercise;

import java.util.Scanner;

public class Task_06_TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (char charOne = 'a'; charOne < 'a' + n; charOne++) {
            for (int charTwo = 'a'; charTwo < 'a' + n; charTwo++) {
                for (int charThree = 'a'; charThree < 'a' + n; charThree++) {
                    System.out.printf("%c%c%c%n", charOne, charTwo, charThree);
                }

            }
        }
    }
}
