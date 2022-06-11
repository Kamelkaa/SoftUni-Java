package Exercise;

import java.util.Scanner;

public class Task_06_StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int startNumber = number;
        int sumFactorial = 0;

        while (number != 0) {
            int digit = number % 10;
            int factorialDigit = 1;

            for (int i = 1; i <= digit; i++) {
                factorialDigit *= i;
            }

            sumFactorial += factorialDigit;
            number /= 10;
        }

        if (startNumber == sumFactorial) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
