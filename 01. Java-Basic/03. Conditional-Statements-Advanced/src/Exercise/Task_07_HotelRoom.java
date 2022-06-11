package Exercise;

import java.util.Scanner;

public class Task_07_HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int countNights = Integer.parseInt(scanner.nextLine());

        double priceStudio = 0;
        double priceApartment = 0;
        String typeRoom = "";

        switch (month) {
            case "May":
            case "October":
                priceStudio = 50;
                priceApartment = 65;
                if (countNights > 7 && countNights <= 14) {
                    priceStudio = priceStudio * 0.95;
                } else if (countNights > 14) {
                    priceStudio = priceStudio * 0.70;
                }
                break;
            case "June":
            case "September":
                priceStudio = 75.20;
                priceApartment = 68.70;
                if (countNights > 14) {
                    priceStudio = priceStudio * 0.80;
                }
                break;
            case "July":
            case "August":
                priceStudio = 76;
                priceApartment = 77;
                break;
        }

        if (countNights > 14) {
            priceApartment = priceApartment * 0.90;
        }

        double totalPriceStudio = priceStudio * countNights;
        double totalPriceApartment = priceApartment * countNights;

        System.out.printf("Apartment: %.2f lv.%n" +
                        "Studio: %.2f lv.",
                totalPriceApartment, totalPriceStudio);
    }
}
