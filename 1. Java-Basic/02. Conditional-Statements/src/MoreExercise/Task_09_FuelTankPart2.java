package MoreExercise;

import java.util.Scanner;

public class Task_09_FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfFuel = scanner.nextLine();
        double litresOfFuel = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine();

        double price = 0;

        switch (typeOfFuel) {
            case "Gas":
                price = litresOfFuel * 0.93;
                if (clubCard.equals("Yes")) {
                    price = price - litresOfFuel * 0.08;
                }
                break;
            case "Gasoline":
                price = litresOfFuel * 2.22;
                if (clubCard.equals("Yes")) {
                    price = price - litresOfFuel * 0.18;
                }
                break;
            case "Diesel":
                price = litresOfFuel * 2.33;
                if (clubCard.equals("Yes")) {
                    price = price - litresOfFuel * 0.12;
                }
                break;
        }

        if (litresOfFuel >= 20 && litresOfFuel <= 25) {
            price = price * 0.92;
        } else if (litresOfFuel > 25) {
            price = price * 0.90;
        }

        System.out.printf("%.2f lv.", price);
    }
}

