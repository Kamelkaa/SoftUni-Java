package MoreExercise;

import java.util.Scanner;

public class Task_08_FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfFuel = scanner.nextLine();
        int litersOfFuel = Integer.parseInt(scanner.nextLine());

        if (typeOfFuel.equals("Diesel") || typeOfFuel.equals("Gasoline") || typeOfFuel.equals("Gas")) {

            if (litersOfFuel >= 25) {
                System.out.printf("You have enough %s.", typeOfFuel.toLowerCase());
            } else {
                System.out.printf("Fill your tank with %s!", typeOfFuel.toLowerCase());
            }

        } else {
            System.out.println("Invalid fuel!");
        }
    }
}
