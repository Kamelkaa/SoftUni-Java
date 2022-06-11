package MoreExercise;

import java.util.Scanner;

public class Task_06_Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mouths = Integer.parseInt(scanner.nextLine());
        double water = 20 * mouths;
        double internet = 15 * mouths;
        double other = 0;
        double totalElectricity = 0;

        for (int i = 0; i < mouths; i++) {
            double electricity = Double.parseDouble(scanner.nextLine());
            totalElectricity = totalElectricity + electricity;
            other = other + ((electricity + 20 + 15) * 1.20);
        }

        double average = (totalElectricity + water + internet + other) / mouths;

        System.out.printf("Electricity: %.2f lv%n", totalElectricity);
        System.out.printf("Water: %.2f lv%n", water);
        System.out.printf("Internet: %.2f lv%n", internet);
        System.out.printf("Other: %.2f lv%n", other);
        System.out.printf("Average: %.2f lv", average);
    }
}
