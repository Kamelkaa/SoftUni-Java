package Exercise;

import java.util.Scanner;

public class Task_02_EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());

        for (int i = numberOne; i <= numberTwo; i++) {

            String current = "" + i;
            int oddSum = 0;
            int evenSum = 0;

            for (int j = 0; j < current.length(); j++) {
                int currentDigit = Integer.parseInt("" + current.charAt(j));
                if (j % 2 == 0) {
                    oddSum += currentDigit;
                } else {
                    evenSum += currentDigit;
                }
            }

            if (oddSum == evenSum) {
                System.out.print(i + " ");
            }
        }
    }
}
