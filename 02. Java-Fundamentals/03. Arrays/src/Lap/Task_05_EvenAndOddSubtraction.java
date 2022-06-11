package Lap;

import java.util.Arrays;
import java.util.Scanner;

public class Task_05_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int evenSum = 0;
        int oddSum = 0;

        for (int number : arrayOfNumbers) {
            if (number % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }

        int difference = evenSum - oddSum;
        System.out.print(difference);
    }
}
