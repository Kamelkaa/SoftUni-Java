package MoreExercise;

import java.util.Scanner;

public class Task_04_CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String typeClass = "";
        String typeCar = "";

        switch (season) {
            case "Summer":
                if (budget <= 100) {
                    typeClass = "Economy class";
                    typeCar = "Cabrio";
                    budget = budget * 0.35;

                } else if (budget > 100 && budget <= 500) {
                    typeClass = "Compact class";
                    typeCar = "Cabrio";
                    budget = budget * 0.45;

                } else if (budget > 500) {
                    typeClass = "Luxury class";
                    typeCar = "Jeep";
                    budget = budget * 0.90;
                }
                break;

            case "Winter":
                if (budget <= 100) {
                    typeClass = "Economy class";
                    typeCar = "Jeep";
                    budget = budget * 0.65;

                } else if (budget > 100 && budget <= 500) {
                    typeClass = "Compact class";
                    typeCar = "Jeep";
                    budget = budget * 0.80;

                } else if (budget > 500) {
                    typeClass = "Luxury class";
                    typeCar = "Jeep";
                    budget = budget * 0.90;
                }
                break;
        }

        System.out.printf("%s%n", typeClass);
        System.out.printf("%s - %.2f", typeCar, budget);
    }
}
