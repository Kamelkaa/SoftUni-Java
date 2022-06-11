package MoreExercise;

import java.util.Scanner;

public class Task_05_Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int neededHours = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int overtimeEmployees = Integer.parseInt(scanner.nextLine());

        double hoursForWork = days * 0.9 * 8;
        double overtimeHours = overtimeEmployees * 2 * days;
        double totalHours = Math.floor(hoursForWork + overtimeHours);

        if (totalHours >= neededHours) {
            double leftHours = totalHours - neededHours;
            System.out.printf("Yes!%.0f hours left.", leftHours);

        } else {
            double neededMoreHours = neededHours - totalHours;
            System.out.printf("Not enough time!%.0f hours needed.", neededMoreHours);
        }
    }
}
