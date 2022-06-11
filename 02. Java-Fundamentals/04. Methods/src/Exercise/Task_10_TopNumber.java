package Exercise;

import java.util.Scanner;

public class Task_10_TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number ; i++) {
            if(isDivisibleByEight(i) && isNumberHoldOddDigit(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean isDivisibleByEight(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum % 8 == 0;
    }

    private static boolean isNumberHoldOddDigit(int number) {
        int counter = 0;

        while (number > 0) {
            if ((number % 10) % 2 == 1) {
                counter++;
            }
            number /= 10;
        }
        return counter >= 1;
    }
}
