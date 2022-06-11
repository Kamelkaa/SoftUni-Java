package MoreExercise;

import java.util.Scanner;

public class Task_03_Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int areaVineyardX = Integer.parseInt(scanner.nextLine());
        double grapesPerMeterY = Double.parseDouble(scanner.nextLine());
        int neededLitresWineZ = Integer.parseInt(scanner.nextLine());
        int numbersWorkers = Integer.parseInt(scanner.nextLine());

        double totalGrapes = areaVineyardX * grapesPerMeterY;
        double wine = totalGrapes * 0.4 / 2.5;

        if (wine < neededLitresWineZ) {
            double neededWine = Math.floor(neededLitresWineZ - wine);

            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", neededWine);

        } else if (wine >= neededLitresWineZ) {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(wine));

            double leftWine = Math.ceil(wine - neededLitresWineZ);
            double winePerWorker = Math.ceil(leftWine / numbersWorkers);

            System.out.printf("%.0f liters left -> %.0f liters per person.", leftWine, winePerWorker);
        }
    }
}
