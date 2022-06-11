package MoreExercise;

import java.time.temporal.IsoFields;
import java.util.Scanner;

public class Task_06_TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());

        double earnings = 0;

        switch (season) {
            case "Spring":
            case "Autumn":
                if (kmPerMonth <= 5000) {
                    earnings = kmPerMonth * 0.75 * 4 * 0.90;

                } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                    earnings = kmPerMonth * 0.95 * 4 * 0.90;
                }
                break;

            case "Summer":
                if (kmPerMonth <= 5000) {
                    earnings = kmPerMonth * 0.90 * 4 * 0.90;

                } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                    earnings = kmPerMonth * 1.10 * 4 * 0.90;
                }
                break;

            case "Winter":
                if (kmPerMonth <= 5000) {
                    earnings = kmPerMonth * 1.05 * 4 * 0.90;

                } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                    earnings = kmPerMonth * 1.25 * 4 * 0.90;
                }
                break;
        }

        if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
            earnings = kmPerMonth * 1.45 * 4 * 0.90;
        }

        System.out.printf("%.2f", earnings);
    }
}

