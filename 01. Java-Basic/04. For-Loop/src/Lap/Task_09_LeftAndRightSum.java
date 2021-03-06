package Lap;

import java.util.Scanner;

public class Task_09_LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            leftSum = leftSum + currentNumber;
        }

        for (int i = 0; i < n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            rightSum = rightSum + currentNumber;
        }

        if (leftSum == rightSum) {
            System.out.printf("Yes, sum = %d", leftSum);
        } else {
            int result = Math.abs(leftSum - rightSum);
            System.out.printf("No, diff = %d", result);
        }
    }
}
