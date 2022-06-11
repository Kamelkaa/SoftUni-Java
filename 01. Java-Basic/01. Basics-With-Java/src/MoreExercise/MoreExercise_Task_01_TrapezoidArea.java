package MoreExercise;

import java.util.Scanner;

public class MoreExercise_Task_01_TrapezoidArea {
    public static void main(String[] args) {
        // основа б1, основа б2, височина
        // лице на трапец = (основа б1 + основа б2) * височина / 2
        Scanner scanner = new Scanner(System.in);

        double baseB1 = Double.parseDouble(scanner.nextLine());
        double baseB2 = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        double area = ((baseB1 + baseB2) * height) / 2;

        System.out.printf("%.2f", area);
    }
}
