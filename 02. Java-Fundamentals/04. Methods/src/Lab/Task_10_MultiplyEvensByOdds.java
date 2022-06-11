package Lab;

import java.util.Scanner;

public class Task_10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int multipliedEvensByOdds = getMultipliedEvensByOdds(Math.abs(number));
        System.out.println(multipliedEvensByOdds);
    }

    private static int getMultipliedEvensByOdds(int number) {
        int sumOfEvens = getSumOfEvensNumbers(number);
        int sumOfOdds = getSumOfOddsNumbers(number);

        return sumOfEvens * sumOfOdds;
    }

    private static int getSumOfEvensNumbers(int number) {
        int evensSum = 0;

        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                evensSum += digit;
            }
            number = number/ 10;
        }

        return evensSum;
    }

    private static int getSumOfOddsNumbers(int number) {
        int oddsSum = 0;

        while (number > 0) {
           int digit = number % 10;
            if (digit % 2 == 1) {
                oddsSum += digit;
            }
            number = number / 10;
        }

        return oddsSum;
    }
}
