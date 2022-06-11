package MoreExercise;

import java.util.Scanner;

public class Task_03_Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersChrysanthemums = Integer.parseInt(scanner.nextLine());
        int numbersRoses = Integer.parseInt(scanner.nextLine());
        int numberTulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String isHoliday = scanner.nextLine();

        int totalFlowers = numbersChrysanthemums + numbersRoses + numberTulips;
        double price = 1;

        switch (season) {

            case "Spring":
                if (numberTulips > 7) {
                    price = price * 0.95;
                }
            case "Summer":
                price *= numbersChrysanthemums * 2.00 + numbersRoses * 4.10 + numberTulips * 2.50;
                break;

            case "Autumn":
            case "Winter":
                if (numbersRoses >= 10 && !season.equals("Autumn")) {
                    price = price * 0.90;
                }
                price *= numbersChrysanthemums * 3.75 + numbersRoses * 4.50 + numberTulips * 4.15;
                break;

        }

        if (isHoliday.equals("Y")) {
            price = price * 1.15;
        }

        if (totalFlowers > 20) {
            price = price * 0.80;
        }

        double finalPrice = price + 2;
        System.out.printf("%.2f", finalPrice);

    }
}
