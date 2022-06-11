package Exercise;

import java.util.Scanner;

public class Task_03_SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int sumPrime = 0;
        int sumNotPrime = 0;

        while (!input.equals("stop")) {
            int number = Integer.parseInt(input);

            if (number < 0) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }

            int counterDel = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    counterDel++;
                }
            }

            if (counterDel == 2) {
                sumPrime += number;
            } else {
                sumNotPrime += number;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d%n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d", sumNotPrime);
    }
}
