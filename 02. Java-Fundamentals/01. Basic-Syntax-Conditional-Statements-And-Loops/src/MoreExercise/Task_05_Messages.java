package MoreExercise;

import java.util.Scanner;

public class Task_05_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersLetters = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numbersLetters; i++) {
            int numbers = Integer.parseInt(scanner.nextLine());

            String numbersString = Integer.toString(numbers);
            int countDigits = numbersString.length();
            int mainDigit = numbers % 10;
            int offset = (mainDigit - 2) * 3;

            if (mainDigit == 8 || mainDigit == 9) {
                offset++;
            }

            int letterIndex = offset + countDigits - 1;

            if (numbers == 0) {
                System.out.print(" ");
            } else {
                System.out.print((char) (letterIndex + 97));
            }
        }
    }
}
