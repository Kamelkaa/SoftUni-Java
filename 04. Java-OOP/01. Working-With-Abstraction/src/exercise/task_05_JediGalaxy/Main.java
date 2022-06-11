package exercise.task_05_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);
        StarsManipulator starsManipulator = new StarsManipulator(galaxy);

        String commandInput = scanner.nextLine();
        long sum = 0;
        while (!commandInput.equals("Let the Force be with you")) {
            int[] playerPositions = Arrays.stream(commandInput.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] enemyPositions = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            starsManipulator.destroyStars(enemyPositions);
            sum += starsManipulator.sumOfStars(playerPositions);

            commandInput = scanner.nextLine();
        }

        System.out.println(sum);
    }
}
