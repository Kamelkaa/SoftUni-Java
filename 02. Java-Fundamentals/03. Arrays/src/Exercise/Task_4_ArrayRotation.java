package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Task_4_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {
            int firstNumber = arrayOfNumbers[0];

            for (int j = 0; j < arrayOfNumbers.length - 1; j++) {
                arrayOfNumbers[j] = arrayOfNumbers[j + 1];
            }

            arrayOfNumbers[arrayOfNumbers.length - 1] = firstNumber;
        }

        for (int number : arrayOfNumbers) {
            System.out.printf("%d ", number);
        }
    }
}
