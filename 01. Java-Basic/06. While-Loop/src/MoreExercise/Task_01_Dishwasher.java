package MoreExercise;

import java.util.Scanner;

public class Task_01_Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberBottles = Integer.parseInt(scanner.nextLine());
        String text = scanner.nextLine();

        int ml = numberBottles * 750;
        int numberDashes = 0;
        int numberPots = 0;
        int counter = 0;
        int neededMlForDashes = 0;
        int neededMlForPots = 0;
        int leftMl = 0;

        while (!text.equals("End")) {
            int numberOfVessels = Integer.parseInt(text);

            counter++;

            if (counter % 3 == 0) {
                numberPots += numberOfVessels;
                neededMlForPots = numberPots * 15;

            } else {
                numberDashes += numberOfVessels;
                neededMlForDashes = numberDashes * 5;

            }

            leftMl = neededMlForDashes + neededMlForPots;

            if (ml < leftMl) {
                int needed = leftMl - ml;
                System.out.printf("Not enough detergent, %d ml. more necessary!", needed);
                break;
            }

            text = scanner.nextLine();
        }

        if (text.equals("End")) {
            int left = ml - leftMl;
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n" +
                    "Leftover detergent %d ml.", numberDashes, numberPots, left);
        }
    }
}
