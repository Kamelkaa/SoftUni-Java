package Exercise;

import java.util.Scanner;

public class Task_05_DivideWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int counterDivineBy2 = 0;
        int counterDivineBy3 = 0;
        int counterDivineBy4 = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number % 2 == 0) {
                counterDivineBy2 += 1;
            }
            if (number % 3 == 0) {
                counterDivineBy3 += 1;
            }
            if (number % 4 == 0) {
                counterDivineBy4 += 1;
            }
        }

        double p1 = 1.0 * counterDivineBy2 / n * 100;
        double p2 = 1.0 * counterDivineBy3 / n * 100;
        double p3 = 1.0 * counterDivineBy4 / n * 100;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%", p1, p2, p3);
    }
}
