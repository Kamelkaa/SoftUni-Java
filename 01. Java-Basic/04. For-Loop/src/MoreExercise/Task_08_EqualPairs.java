package MoreExercise;

import java.util.Scanner;

public class Task_08_EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int amount = 0;
        int lastAmount = 0;
        int counter = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            int firstNumber = Integer.parseInt(scanner.nextLine());
            int secondNumber = Integer.parseInt(scanner.nextLine());

            amount = firstNumber + secondNumber;

            if (amount == lastAmount) {
                counter++;

            }

            if (maxDiff < Math.abs(lastAmount - amount) && i >= 1) {
                maxDiff = Math.abs(lastAmount - amount);

            }

            if (amount != lastAmount) {
                lastAmount = amount;

            }
        }

        if (counter == n - 1) {
            System.out.println("Yes, value=" + amount);

        } else {
            System.out.println("No, maxdiff=" + maxDiff);

        }
    }
}
