package Lap;

import java.util.Scanner;

public class Task_08_GraduationPt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int grade = 1;
        double sum = 0;
        int repetitions = 0;
        boolean isOut = false;

        while (grade <= 12) {
            double schoolGrade = Double.parseDouble(scanner.nextLine());

            if (schoolGrade < 4) {
                repetitions++;

                if (repetitions == 2) {
                    isOut = true;
                    System.out.printf("%s has been excluded at %d grade", name, grade);
                    break;
                }

                continue;
            }

            sum += schoolGrade;
            grade++;
        }

        if (!isOut) {
            double averageSum = sum / (grade - 1);
            System.out.printf("%s graduated. Average grade: %.2f", name, averageSum);
        }
    }
}
