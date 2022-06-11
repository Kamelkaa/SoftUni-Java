package MoreExercise;

import java.util.Scanner;

public class Task_04_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfStudents = Integer.parseInt(scanner.nextLine());
        int counterTop = 0;
        int counterGood = 0;
        int counterNotGood = 0;
        int counterFail = 0;
        double amountOfGrade = 0;

        for (int i = 0; i < numbersOfStudents; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            amountOfGrade = amountOfGrade + grade;

            if (grade >= 2 && grade <= 2.99) {
                counterFail++;

            } else if (grade >= 3 && grade <= 3.99) {
                counterNotGood++;

            } else if (grade >= 4 && grade <= 4.99) {
                counterGood++;

            } else if (grade >= 5) {
                counterTop++;
            }
        }

        double averageGrade = amountOfGrade / numbersOfStudents;
        double percentTop = counterTop * 100.0 / numbersOfStudents;
        double percentGood = counterGood * 100.0 / numbersOfStudents;
        double percentNotGood = counterNotGood * 100.0 / numbersOfStudents;
        double percentFail = counterFail * 100.0 / numbersOfStudents;

        System.out.printf("Top students: %.2f%%%n", percentTop);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", percentGood);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", percentNotGood);
        System.out.printf("Fail: %.2f%%%n", percentFail);
        System.out.printf("Average: %.2f", averageGrade);
    }
}
