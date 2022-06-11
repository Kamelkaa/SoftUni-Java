package MoreExercise;

import java.util.Scanner;

public class Task_02_BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfJuniors = Integer.parseInt(scanner.nextLine());
        int numbersOfSeniors = Integer.parseInt(scanner.nextLine());
        String typeOfRoute = scanner.nextLine();

        double moneyFromJuniors = 0;
        double moneyFromSenors = 0;

        switch (typeOfRoute) {
            case "trail":
                moneyFromJuniors = numbersOfJuniors * 5.50;
                moneyFromSenors = numbersOfSeniors * 7;
                break;

            case "cross-country":
                moneyFromJuniors = numbersOfJuniors * 8.00;
                moneyFromSenors = numbersOfSeniors * 9.50;

                if (numbersOfJuniors + numbersOfSeniors >= 50) {
                    moneyFromJuniors = moneyFromJuniors * 0.75;
                    moneyFromSenors = moneyFromSenors * 0.75;
                }

                break;

            case "downhill":
                moneyFromJuniors = numbersOfJuniors * 12.25;
                moneyFromSenors = numbersOfSeniors * 13.75;
                break;

            case "road":
                moneyFromJuniors = numbersOfJuniors * 20.00;
                moneyFromSenors = numbersOfSeniors * 21.50;
                break;
        }

        double amount = (moneyFromJuniors + moneyFromSenors) * 0.95;

        System.out.printf("%.2f", amount);
    }
}
