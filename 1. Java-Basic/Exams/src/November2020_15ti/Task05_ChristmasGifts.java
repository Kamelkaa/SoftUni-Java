package November2020_15ti;

import java.util.Scanner;

public class Task05_ChristmasGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String years = scanner.nextLine();
        int numberOfAdults = 0;
        int numberOfKids = 0;

        while (!years.equals("Christmas")) {
            int yearToNumbers = Integer.parseInt(years);

            if (yearToNumbers <= 16) {
                numberOfKids += 1;
            } else {
                numberOfAdults += 1;
            }
            years = scanner.nextLine();
        }

        int priceForToys = numberOfKids * 5;
        int priceForSweaters = numberOfAdults * 15;

        System.out.printf("Number of adults: %d%n" +
                        "Number of kids: %d%nMoney for toys: %d%n" +
                        "Money for sweaters: %d",
                numberOfAdults, numberOfKids, priceForToys, priceForSweaters);

    }
}

