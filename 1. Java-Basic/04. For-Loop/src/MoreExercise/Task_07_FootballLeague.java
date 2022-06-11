package MoreExercise;

import java.util.Scanner;

public class Task_07_FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacityOfStadium = Integer.parseInt(scanner.nextLine());
        int numbersOfFans = Integer.parseInt(scanner.nextLine());

        int counterSectorA = 0;
        int counterSectorB = 0;
        int counterSectorV = 0;
        int counterSectorG = 0;

        for (int i = 0; i < numbersOfFans; i++) {
            String sector = scanner.nextLine();

            if (sector.equals("A")) {
                counterSectorA++;

            } else if (sector.equals("B")) {
                counterSectorB++;

            } else if (sector.equals("V")) {
                counterSectorV++;

            } else if (sector.equals("G")) {
                counterSectorG++;

            }
        }

        double percentSectorA = counterSectorA * 100.0 / numbersOfFans;
        double percentSectorB = counterSectorB * 100.0 / numbersOfFans;
        double percentSectorV = counterSectorV * 100.0 / numbersOfFans;
        double percentSectorG = counterSectorG * 100.0 / numbersOfFans;
        double percentAllFens = numbersOfFans * 100.0 / capacityOfStadium;

        System.out.printf("%.2f%%%n", percentSectorA);
        System.out.printf("%.2f%%%n", percentSectorB);
        System.out.printf("%.2f%%%n", percentSectorV);
        System.out.printf("%.2f%%%n", percentSectorG);
        System.out.printf("%.2f%%", percentAllFens);
    }
}
