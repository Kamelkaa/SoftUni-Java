package Exercise;

import java.util.Scanner;

public class Task_04_FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int counterFishers = Integer.parseInt(scanner.nextLine());

        double rentForBoat = 0;

        switch (season) {
            case "Spring":
                rentForBoat = 3000;
                break;
            case "Summer":
            case "Autumn":
                rentForBoat = 4200;
                break;
            case "Winter":
                rentForBoat = 2600;
                break;
        }

        if (counterFishers <= 6) {
            rentForBoat = 0.90 * rentForBoat;
        } else if (counterFishers >= 7 && counterFishers <= 11) {
            rentForBoat = 0.85 * rentForBoat;
        } else if (counterFishers >= 12) {
            rentForBoat = 0.75 * rentForBoat;
        }

        if (counterFishers % 2 == 0 && !season.equals("Autumn")) {
            rentForBoat = rentForBoat * 0.95;
        }


        if (budget >= rentForBoat) {
            double leftMoney = budget - rentForBoat;
            System.out.printf("Yes! You have %.2f leva left.", leftMoney);
        } else {
            double neededMoney = rentForBoat - budget;
            System.out.printf("Not enough money! You need %.2f leva.", neededMoney);
        }
    }
}