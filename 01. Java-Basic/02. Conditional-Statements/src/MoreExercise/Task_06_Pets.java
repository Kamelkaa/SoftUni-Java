package MoreExercise;

import java.util.Scanner;

public class Task_06_Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDays = Integer.parseInt(scanner.nextLine());
        int foodKg = Integer.parseInt(scanner.nextLine());
        double foodForDogKg = Double.parseDouble(scanner.nextLine());
        double foodForCatKg = Double.parseDouble(scanner.nextLine());
        double foodForTurtleGr = Double.parseDouble(scanner.nextLine());

        double neededFoodDog = numberOfDays * foodForDogKg;
        double neededFoodCat = numberOfDays * foodForCatKg;
        double neededFoodTurtle = numberOfDays * foodForTurtleGr / 1000;
        double totalFoodNeeded = neededFoodDog + neededFoodCat + neededFoodTurtle;

        if (totalFoodNeeded <= foodKg) {
            double foodLeft = Math.floor(foodKg - totalFoodNeeded);
            System.out.printf("%.0f kilos of food left.", foodLeft);

        } else {
            double neededFood = Math.ceil(totalFoodNeeded - foodKg);
            System.out.printf("%.0f more kilos of food are needed.", neededFood);
        }
    }
}
