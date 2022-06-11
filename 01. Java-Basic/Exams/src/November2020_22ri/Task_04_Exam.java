package November2020_22ri;

import java.util.Scanner;

public class Task_04_Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersStudents = Integer.parseInt(scanner.nextLine());
        int counterGroup1 = 0;
        int counterGroup2 = 0;
        int counterGroup3 = 0;
        int counterGroup4 = 0;
        double sumGrade = 0;


        for (int i = 0; i < numbersStudents; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            sumGrade += grade;

            if (grade >= 5) {
                counterGroup1++;
            } else if (grade >= 4 && grade <= 4.99) {
                counterGroup2++;
            } else if (grade >= 3 && grade <= 3.99) {
                counterGroup3++;
            } else if (grade < 3) {
                counterGroup4++;
            }
        }

        double percentStudentsGr1 = counterGroup1 * 1.00 / numbersStudents * 100;
        double percentStudentsGr2 = counterGroup2 * 1.00 / numbersStudents * 100;
        double percentStudentsGr3 = counterGroup3 * 1.00 / numbersStudents * 100;
        double percentStudentsGr4 = counterGroup4 * 1.00 / numbersStudents * 100;

        double averageGrade = sumGrade / numbersStudents;

        System.out.printf("Top students: %.2f%%%n", percentStudentsGr1);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", percentStudentsGr2);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", percentStudentsGr3);
        System.out.printf("Fail: %.2f%%%n", percentStudentsGr4);
        System.out.printf("Average: %.2f", averageGrade);
    }
}
