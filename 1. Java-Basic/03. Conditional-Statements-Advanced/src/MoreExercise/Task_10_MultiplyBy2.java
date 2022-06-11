package MoreExercise;

import java.util.Scanner;

public class Task_10_MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        while (number >= 0) {

            double multiply = number * 2;
            System.out.printf("Result: %.2f%n", multiply);

            number = Double.parseDouble(scanner.nextLine());
        }

        if (number < 0) {
            System.out.println("Negative number!");
        }
    }
}
