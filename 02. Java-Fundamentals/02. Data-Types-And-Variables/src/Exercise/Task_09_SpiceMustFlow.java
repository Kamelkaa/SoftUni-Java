package Exercise;

import java.util.Scanner;

public class Task_09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int counterDays = 0;
        int amount = 0;
        int totalAmount = 0;

        if (startingYield >= 100) {
            while (startingYield >= 100) {
                int endOfTheShift = startingYield - 26;
                amount += endOfTheShift;
                counterDays++;
                startingYield = startingYield - 10;
            }

            totalAmount = amount - 26;
        }

        System.out.printf("%d%n%d", counterDays, totalAmount);
    }
}
