package MoreExercise;

import java.util.Scanner;

public class Task_03_Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLoads = Integer.parseInt(scanner.nextLine());

        int minibusTons = 0;
        int priceMinibus = 0;

        int truckTons = 0;
        int priceTruck = 0;

        int trainTons = 0;
        int priceTrain = 0;

        int allCargo = 0;


        for (int i = 0; i < numberOfLoads; i++) {
            int tonsOfCargo = Integer.parseInt(scanner.nextLine());

            if (tonsOfCargo <= 3) {
                minibusTons = minibusTons + tonsOfCargo;
                priceMinibus = priceMinibus + 200 * tonsOfCargo;

            } else if (tonsOfCargo >= 4 && tonsOfCargo <= 11) {
                truckTons = truckTons + tonsOfCargo;
                priceTruck = priceTruck + 175 * tonsOfCargo;

            } else if (tonsOfCargo >= 12) {
                trainTons = trainTons + tonsOfCargo;
                priceTrain = priceTrain + 120 * tonsOfCargo;

            }

            allCargo = allCargo + tonsOfCargo;
        }

        double averagePrice = (priceMinibus * 1.0 + priceTruck + priceTrain) / allCargo;
        double percentMinibus = minibusTons * 1.0 / allCargo * 100;
        double percentTruck = truckTons * 1.0 / allCargo * 100;
        double percentTrain = trainTons * 1.0 / allCargo * 100;

        System.out.printf("%.2f%n" +
                "%.2f%%%n" +
                "%.2f%%%n" +
                "%.2f%%", averagePrice, percentMinibus, percentTruck, percentTrain);
    }
}
