package November2020_15ti;

import java.util.Scanner;

public class Task_06_GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int location = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < location; i++) {
            double averageProducePerDay = Double.parseDouble(scanner.nextLine());

            int days = Integer.parseInt(scanner.nextLine());
            double averageProduce = 0.0;

            for (int j = 0; j < days; j++) {
                double produce = Double.parseDouble(scanner.nextLine());
                averageProduce += produce;
            }

            double average = averageProduce / days;

            if (average >= averageProducePerDay) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", average);
            } else {
                double neededGold = averageProducePerDay - average;
                System.out.printf("You need %.2f gold.%n", neededGold);
            }
        }
    }
}
