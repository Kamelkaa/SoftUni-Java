package Lap;

import java.util.Scanner;

public class Task_13_SkiTripSTAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String tipRoom = scanner.nextLine();
        String rating = scanner.nextLine();

        double nights = days - 1;
        double price = 0;

        switch (tipRoom) {
            case "room for one person":
                price = 18 * nights;
                break;

            case "apartment":

                if (nights <= 10) {
                    price = (25 * nights) * 0.70;
                } else if (nights > 10 && nights <= 15) {
                    price = (25 * nights) * 0.65;
                } else {
                    price = (25 * nights) * 0.50;
                }
                break;

            case "president apartment":

                if (nights <= 10) {
                    price = (35 * nights) * 0.90;
                } else if (nights > 10 && nights <= 15) {
                    price = (35 * nights) * 0.85;
                } else {
                    price = (35 * nights) * 0.80;
                }
                break;
        }
        if (rating.equals("positive")) {
            price *= 1.25;
            System.out.printf("%.2f", price);
        }
        if (rating.equals("negative")) {
            price *= 0.90;
            System.out.printf("%.2f", price);
        }
    }
}
