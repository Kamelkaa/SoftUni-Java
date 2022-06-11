package Lap;

import java.util.Scanner;

public class Task_08_NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());

            if (currentNumber > max) {
                max = currentNumber;
            }
            if (currentNumber < min) {
                min = currentNumber;
            }
        }

        System.out.printf("Max number: %d%nMin number: %d", max, min);
    }
}
