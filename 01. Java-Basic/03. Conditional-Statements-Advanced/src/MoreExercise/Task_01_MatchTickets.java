package MoreExercise;

import java.util.Scanner;

public class Task_01_MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int numbersOfPeople = Integer.parseInt(scanner.nextLine());

        double currentBudget = 0;

        if (numbersOfPeople >= 1 && numbersOfPeople <= 4) {
            currentBudget = budget * 0.25;
        } else if (numbersOfPeople >= 5 && numbersOfPeople <= 9) {
            currentBudget = budget * 0.40;
        } else if (numbersOfPeople >= 10 && numbersOfPeople <= 24) {
            currentBudget = budget * 0.50;
        } else if (numbersOfPeople >= 25 && numbersOfPeople <= 49) {
            currentBudget = budget * 0.60;
        } else if (numbersOfPeople >= 50) {
            currentBudget = budget * 0.75;
        }

        switch (category) {
            case "VIP":
                double ticketPriceVip = 499.99 * numbersOfPeople;

                if (currentBudget >= ticketPriceVip) {
                    double moneyLeft = currentBudget - ticketPriceVip;
                    System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
                } else {
                    double moneyNeed = ticketPriceVip - currentBudget;
                    System.out.printf("Not enough money! You need %.2f leva.", moneyNeed);
                }

                break;

            case "Normal":
                double ticketPriceNormal = 249.99 * numbersOfPeople;

                if (currentBudget >= ticketPriceNormal) {
                    double moneyLeft = currentBudget - ticketPriceNormal;
                    System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
                } else {
                    double moneyNeed = ticketPriceNormal - currentBudget;
                    System.out.printf("Not enough money! You need %.2f leva.", moneyNeed);
                }
                break;
        }
    }
}
