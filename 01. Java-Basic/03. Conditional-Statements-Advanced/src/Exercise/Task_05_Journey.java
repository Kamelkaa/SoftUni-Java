package Exercise;

import java.util.Scanner;

public class Task_05_Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        String typeVacation = "";
        double spentMoney = 0;

        switch (season) {

            case "summer":
                typeVacation = "Camp";
                if (budget <= 100) {
                    destination = "Bulgaria";
                    spentMoney = budget * .30;
                } else if (budget > 100 && budget <= 1000) {
                    destination = "Balkans";
                    spentMoney = budget * 0.40;
                }
                break;

            case "winter":
                typeVacation = "Hotel";
                if (budget <= 100) {
                    destination = "Bulgaria";
                    spentMoney = budget * 0.70;
                } else if (budget > 100 && budget <= 1000) {
                    destination = "Balkans";
                    spentMoney = budget * 0.80;
                }
                break;
        }
        if (budget > 1000) {
            typeVacation = "Hotel";
            destination = "Europe";
            spentMoney = budget * 0.90;
        }

        System.out.printf("Somewhere in %s%n" +
                        "%s - %.2f",
                destination, typeVacation, spentMoney);
    }
}
