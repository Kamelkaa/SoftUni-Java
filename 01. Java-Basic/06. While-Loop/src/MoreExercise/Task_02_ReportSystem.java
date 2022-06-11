package MoreExercise;

import java.util.Scanner;

public class Task_02_ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalAmount = Integer.parseInt(scanner.nextLine());
        String text = scanner.nextLine();

        int counter = 1;
        int counterCache = 0;
        int counterCard = 0;
        int currentCache = 0;
        int currentCard = 0;
        int currentAmount = 0;

        while (!text.equals("End")) {
            int amount = Integer.parseInt(text);

            if (counter % 2 == 1) {
                if (amount > 100) {
                    System.out.println("Error in transaction!");

                } else {
                    System.out.println("Product sold!");
                    currentAmount += amount;
                    currentCache += amount;
                    counterCache++;
                }

            } else if (counter % 2 == 0) {
                if (amount < 10) {
                    System.out.println("Error in transaction!");

                } else {
                    System.out.println("Product sold!");
                    currentAmount += amount;
                    currentCard += amount;
                    counterCard++;

                }
            }

            if (currentAmount >= totalAmount) {
                double averageCache = currentCache * 1.0 / counterCache;
                double averageCard = currentCard * 1.0 / counterCard;

                System.out.printf("Average CS: %.2f%nAverage CC: %.2f", averageCache, averageCard);

                break;
            }

            counter++;
            text = scanner.nextLine();
        }

        if (text.equals("End")) {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
