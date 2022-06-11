package March2020;

import java.util.Scanner;

public class Task02_1_CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutesWalk = Integer.parseInt(scanner.nextLine());
        int numberOfWalks = Integer.parseInt(scanner.nextLine());
        int calories = Integer.parseInt(scanner.nextLine());

        int totalMinutesWalk = minutesWalk * numberOfWalks;
        int totalCaloriesBurned = totalMinutesWalk * 5;
        double halfCaloriesConsumed = calories * 0.50;

        if (totalCaloriesBurned >= halfCaloriesConsumed) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", totalCaloriesBurned);
        } else if (totalCaloriesBurned < halfCaloriesConsumed) {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", totalCaloriesBurned);
        }
    }
}
