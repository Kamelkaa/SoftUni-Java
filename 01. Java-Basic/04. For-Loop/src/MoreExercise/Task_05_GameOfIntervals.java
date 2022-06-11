package MoreExercise;

import java.util.Scanner;

public class Task_05_GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfMoves = Integer.parseInt(scanner.nextLine());

        int counterFrom0To9 = 0;
        int counterFrom10To19 = 0;
        int counterFrom20To29 = 0;
        int counterFrom30To39 = 0;
        int counterFrom40To50 = 0;
        int counterInvalidNumber = 0;
        double result = 0;

        for (int i = 0; i < numbersOfMoves; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number >= 0 && number <= 9) {
                counterFrom0To9++;
                result = result + number * 0.20;

            } else if (number >= 10 && number <= 19) {
                counterFrom10To19++;
                result = result + number * 0.30;

            } else if (number >= 20 && number <= 29) {
                counterFrom20To29++;
                result = result + number * 0.40;

            } else if (number >= 30 && number <= 39) {
                counterFrom30To39++;
                result = result + 50;

            } else if (number >= 40 && number <= 50) {
                counterFrom40To50++;
                result = result + 100;

            } else {
                counterInvalidNumber++;
                result = result / 2;

            }
        }

        double percentFrom0To9 = counterFrom0To9 * 100.0 / numbersOfMoves;
        double percentFrom10To19 = counterFrom10To19 * 100.0 / numbersOfMoves;
        double percentFrom20To29 = counterFrom20To29 * 100.0 / numbersOfMoves;
        double percentFrom30To39 = counterFrom30To39 * 100.0 / numbersOfMoves;
        double percentFrom40To50 = counterFrom40To50 * 100.0 / numbersOfMoves;
        double percentInvalidNumber = counterInvalidNumber * 100.0 / numbersOfMoves;

        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", percentFrom0To9);
        System.out.printf("From 10 to 19: %.2f%%%n", percentFrom10To19);
        System.out.printf("From 20 to 29: %.2f%%%n", percentFrom20To29);
        System.out.printf("From 30 to 39: %.2f%%%n", percentFrom30To39);
        System.out.printf("From 40 to 50: %.2f%%%n", percentFrom40To50);
        System.out.printf("Invalid numbers: %.2f%%", percentInvalidNumber);

    }
}
