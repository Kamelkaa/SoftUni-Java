package MidExam04;

import java.util.Arrays;
import java.util.Scanner;

public class Task_03_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighborhood = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int currentIndex = 0;

        while (!input.equals("Love!")) {
            int jumpLength = Integer.parseInt(input.split("\\s+")[1]);
            currentIndex += jumpLength;

            if (currentIndex >= neighborhood.length) {
                currentIndex = 0;
            }

            if (neighborhood[currentIndex] != 0) {
                neighborhood[currentIndex] -= 2;
                if (neighborhood[currentIndex] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            }

            input = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", currentIndex);

        boolean isMissionSuccessful = true;
        int countFails = 0;

        for (int house : neighborhood) {
            if (house != 0) {
                countFails++;
                isMissionSuccessful = false;
            }
        }

        if (isMissionSuccessful) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", countFails);
        }
    }
}
