package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_10_PoisonousPlantsSTAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        String[] pesticideAmount = scanner.nextLine().split(" ");

        ArrayDeque<Integer> indexesOfPlants = new ArrayDeque<>();
        indexesOfPlants.push(0);
        int[] days = new int[numberOfPlants];

        for (int i = 0; i < numberOfPlants; i++) {
            int maxDays = 0;

            while (indexesOfPlants.size() > 0 && Integer.parseInt(pesticideAmount[indexesOfPlants.peek()]) >= Integer.parseInt(pesticideAmount[i])) {
                maxDays = Math.max(maxDays, days[indexesOfPlants.pop()]);
            }

            if (indexesOfPlants.size() > 0) {
                days[i] = maxDays + 1;
            }

            indexesOfPlants.push(i);
        }
        
        System.out.println(numberOfDaysAfterPlantsStopDying(days));
    }

    private static int numberOfDaysAfterPlantsStopDying(int[] days) {
        int max = Integer.MIN_VALUE;
        for (int day : days) {
            if (day > max) {
                max = day;
            }
        }
        return max;
    }
}


