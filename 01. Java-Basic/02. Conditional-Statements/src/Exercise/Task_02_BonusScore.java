package Exercise;

import java.util.Scanner;

public class Task_02_BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        double bonus = 0;

        if (number <= 100) {
            bonus = 5;
        } else if (number > 100 && number < 1000) {
            bonus = 0.2 * number;
        } else if (number > 1000) {
            bonus = 0.1 * number;
        }
        if (number % 2 == 0) {
            bonus = bonus + 1;
        } else if (number % 10 == 5) {
            bonus = bonus + 2;
        }
        double totalBonus = bonus + number;
        System.out.printf("%.1f%n%.1f", bonus, totalBonus);
    }
}
