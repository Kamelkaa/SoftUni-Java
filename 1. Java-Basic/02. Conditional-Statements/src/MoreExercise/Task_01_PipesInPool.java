package MoreExercise;

import java.util.Scanner;

public class Task_01_PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int volumePoolV = Integer.parseInt(scanner.nextLine());
        int rateOfFirstP1 = Integer.parseInt(scanner.nextLine());
        int rateOfSecondP2 = Integer.parseInt(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());

        double occupancyOfPool = rateOfFirstP1 * hours + rateOfSecondP2 * hours;
        double percentOccupancy = (occupancyOfPool * 100) / volumePoolV;
        double percentP1 = (rateOfFirstP1 * hours * 100) / occupancyOfPool;
        double percentP2 = (rateOfSecondP2 * hours * 100) / occupancyOfPool;

        if (occupancyOfPool <= volumePoolV) {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.",
                    percentOccupancy, percentP1, percentP2);
        } else if (occupancyOfPool > volumePoolV) {
            double overflowing = occupancyOfPool - volumePoolV;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", hours, overflowing);
        }
    }
}
