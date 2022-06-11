package MidExam02;

import java.util.Scanner;

public class Task_01_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int totalStudents = Integer.parseInt(scanner.nextLine());
        int countHour = 0;

        while (totalStudents > 0) {
            countHour++;

            if (countHour % 4 == 0) {
                continue;
            }
            totalStudents -= (firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency);
        }

        System.out.printf("Time needed: %dh.", countHour);
    }
}
