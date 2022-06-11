package Exercise;

import java.util.Scanner;

public class Task_04_Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int counterNumberP1 = 0;
        int counterNumberP2 = 0;
        int counterNumberP3 = 0;
        int counterNumberP4 = 0;
        int counterNumberP5 = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 200) {
                counterNumberP1 += 1;
            } else if (number >= 200 && number <= 399) {
                counterNumberP2 += 1;
            } else if (number >= 400 && number <= 599) {
                counterNumberP3 += 1;
            } else if (number >= 600 && number <= 799) {
                counterNumberP4 += 1;
            } else if (number >= 800) {
                counterNumberP5 += 1;
            }
        }

        double p1 = 1.0 * counterNumberP1 / n * 100;
        double p2 = 1.0 * counterNumberP2 / n * 100;
        double p3 = 1.0 * counterNumberP3 / n * 100;
        double p4 = 1.0 * counterNumberP4 / n * 100;
        double p5 = 1.0 * counterNumberP5 / n * 100;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%", p1, p2, p3, p4, p5);
    }
}
