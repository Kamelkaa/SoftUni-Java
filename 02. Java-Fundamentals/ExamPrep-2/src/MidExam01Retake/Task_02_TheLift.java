package MidExam01Retake;

import java.util.Arrays;
import java.util.Scanner;

public class Task_02_TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());
        int[] currentState = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        boolean isLiftIsFull = true;

        while (waitingPeople > 0) {

            for (int i = 0; i < currentState.length; i++) {
                int currentWagon = currentState[i];
                int enteringPpl = 4 - currentState[i];

                if (waitingPeople < 4) {
                    enteringPpl = waitingPeople;
                }
                currentState[i] = enteringPpl + currentWagon;

                if (currentState[i] < 4) {
                    isLiftIsFull = false;
                }
                waitingPeople -= enteringPpl;
            }

            if (waitingPeople > 0) {
                System.out.printf("There isn't enough space! %d people in a queue!%n", waitingPeople);
                break;
            }
        }

        String[] stringArray = Arrays.stream(currentState).mapToObj(String::valueOf)
                .toArray(String[]::new);

        if (!isLiftIsFull) {
            System.out.println("The lift has empty spots!");
        }

        System.out.println(String.join(" ", stringArray));
    }
}
