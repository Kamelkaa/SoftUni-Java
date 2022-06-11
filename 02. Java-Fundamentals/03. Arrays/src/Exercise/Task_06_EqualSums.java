package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Task_06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        boolean isTopInt = false;

        for (int i = 0; i <= arrayOfNumbers.length - 1; i++) {
            int sumLeftNumbers = 0;
            int sumRightNumber = 0;

            for (int l = 0; l <= i - 1; l++) {
                sumLeftNumbers += arrayOfNumbers[l];
            }

            for (int r = i + 1; r <= arrayOfNumbers.length - 1; r++) {
                sumRightNumber += arrayOfNumbers[r];
            }

            if (sumLeftNumbers == sumRightNumber) {
                System.out.println(i);
                isTopInt = true;
            }
        }

        if (!isTopInt) {
            System.out.println("no");
        }
    }
}
