package MoreExercise;

import java.util.Scanner;

public class Task_07_SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String typeGroup = scanner.nextLine();
        int numbersStudents = Integer.parseInt(scanner.nextLine());
        int numbersNights = Integer.parseInt(scanner.nextLine());

        String sport = "";
        double pricePerNight = 0;

        switch (season) {
            case "Winter":
                pricePerNight = 9.60;

                if (typeGroup.equals("girls")) {
                    sport = "Gymnastics";

                } else if (typeGroup.equals("boys")) {
                    sport = "Judo";

                } else if (typeGroup.equals("mixed")) {
                    pricePerNight = 10;
                    sport = "Ski";

                }
                break;

            case "Spring":
                pricePerNight = 7.20;
                if (typeGroup.equals("girls")) {
                    sport = "Athletics";

                } else if (typeGroup.equals("boys")) {
                    sport = "Tennis";

                } else if (typeGroup.equals("mixed")) {
                    pricePerNight = 9.50;
                    sport = "Cycling";

                }
                break;

            case "Summer":
                pricePerNight = 15.00;

                if (typeGroup.equals("girls")) {
                    sport = "GVolleyball";

                } else if (typeGroup.equals("boys")) {
                    sport = "Football";

                } else if (typeGroup.equals("mixed")) {
                    pricePerNight = 20;
                    sport = "Swimming";

                }
                break;
        }

        double priceForAllNights = numbersStudents * pricePerNight * numbersNights;

        if (numbersStudents >= 50) {
            priceForAllNights = priceForAllNights * 0.50;

        } else if (numbersStudents >= 20 && numbersStudents < 50) {
            priceForAllNights = priceForAllNights * 0.85;

        } else if (numbersStudents >= 10 && numbersStudents < 20) {
            priceForAllNights = priceForAllNights * 0.95;

        }

        System.out.printf("%s %.2f lv.", sport, priceForAllNights);
    }
}
