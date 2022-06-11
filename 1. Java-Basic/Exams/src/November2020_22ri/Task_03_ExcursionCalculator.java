package November2020_22ri;

import java.util.Scanner;

public class Task_03_ExcursionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPeople = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();

        double priceForOne = 0;

        switch (season) {
            case "spring":

                if (numberPeople <= 5) {
                    priceForOne = 50.00;
                } else {
                    priceForOne = 48.00;
                }
                break;
            case "summer":

                if (numberPeople <= 5) {
                    priceForOne = 48.50;
                } else {
                    priceForOne = 45.00;
                }
                break;
            case "autumn":

                if (numberPeople <= 5) {
                    priceForOne = 60.00;
                } else {
                    priceForOne = 49.50;
                }
                break;
            case "winter":

                if (numberPeople <= 5) {
                    priceForOne = 86.00;
                } else {
                    priceForOne = 85.00;
                }
                break;
        }

        double totalPrice = numberPeople * priceForOne;

        if (season.equals("summer")) {
            totalPrice = 0.85 * totalPrice;
        } else if (season.equals("winter")) {
            totalPrice = 1.08 * totalPrice;
        }

        System.out.printf("%.2f leva.", totalPrice);
    }
}

