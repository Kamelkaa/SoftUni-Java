package MoreExercise;

import java.util.Scanner;

public class Task_04_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfKm = Integer.parseInt(scanner.nextLine());
        String periodOfTheDay = scanner.nextLine();
        double price = 0;

        if (numbersOfKm < 20) {

            if (periodOfTheDay.equals("day")) {
                price = 0.70 + numbersOfKm * 0.79;
            } else if (periodOfTheDay.equals("night")) {
                price = 0.70 + numbersOfKm * 0.90;
            }

        } else if (numbersOfKm < 100) {
            price = numbersOfKm * 0.09;

        } else {
            price = numbersOfKm * 0.06;
        }

        System.out.printf("%.2f", price);
    }
}
