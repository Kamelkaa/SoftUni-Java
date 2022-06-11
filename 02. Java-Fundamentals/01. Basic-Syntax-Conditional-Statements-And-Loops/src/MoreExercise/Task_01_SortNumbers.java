package MoreExercise;

import java.util.Scanner;

public class Task_01_SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        int numberThree = Integer.parseInt(scanner.nextLine());

        int first = 0;
        int second = 0;
        int third = 0;

        if (numberOne > numberTwo && numberOne > numberThree) {
            first = numberOne;
            if (numberTwo > numberThree) {
                second = numberTwo;
                third = numberThree;
            } else {
                second = numberThree;
                third = numberTwo;
            }
        } else if (numberTwo > numberOne && numberTwo > numberThree) {
            first = numberTwo;
            if (numberOne > numberThree) {
                second = numberOne;
                third = numberThree;
            } else {
                second = numberThree;
                third = numberOne;
            }
        } else if (numberThree > numberOne && numberThree > numberTwo) {
            first = numberThree;
            if (numberOne > numberTwo) {
                second = numberOne;
                third = numberTwo;
            } else {
                second = numberTwo;
                third = numberOne;
            }
        }

        System.out.printf("%d%n%d%n%d", first, second, third);
    }
}
