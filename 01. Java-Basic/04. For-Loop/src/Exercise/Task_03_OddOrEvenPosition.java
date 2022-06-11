package Exercise;

import java.util.Scanner;

public class Task_03_OddOrEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double oddMin = Double.MAX_VALUE;
        double oddMax = Double.MIN_VALUE;
        double evenMin = Double.MAX_VALUE;
        double evenMax = Double.MIN_VALUE;
        double oddSum = 0.00;
        double evenSum = 0.00;

        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            if (i == 1) {
                oddSum = oddSum + number;
                oddMin = number;
                oddMax = number;
            }
            if (i == 2) {
                evenSum = evenSum + number;
                evenMin = number;
                evenMax = number;
            }
            if (i > 2 && i % 2 != 0) {
                oddSum = oddSum + number;

                if (number < oddMin) {
                    oddMin = number;
                } else if (number > oddMax) {
                    oddMax = number;
                }
            }

            if (i > 2 && i % 2 == 0) {
                evenSum = evenSum + number;

                if (number > evenMax) {
                    evenMax = number;
                } else if (number < evenMin) {
                    evenMin = number;
                }
            }
        }

        if (n == 0) {
            System.out.printf("OddSum=%.2f,%nOddMin=No,%nOddMax=No,%nEvenSum=%.2f,%nEvenMin=No,%nEvenMax=No",
                    oddSum, evenSum);
        } else if (n == 1) {
            System.out.printf("OddSum=%.2f,%nOddMin=%.2f,%nOddMax=%.2f,%nEvenSum=%.2f,%nEvenMin=No,%nEvenMax=No",
                    oddSum, oddMin, oddMax, evenSum);
        } else if (n > 1) {
            System.out.printf("OddSum=%.2f,%nOddMin=%.2f,%nOddMax=%.2f,%nEvenSum=%.2f,%nEvenMin=%.2f,%nEvenMax=%.2f",
                    oddSum, oddMin, oddMax, evenSum, evenMin, evenMax);
        }
    }
}

