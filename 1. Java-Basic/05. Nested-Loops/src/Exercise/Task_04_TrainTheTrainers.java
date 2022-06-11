package Exercise;

import java.util.Scanner;

public class Task_04_TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        double allGrades = 0;
        double averageGrade = 0;
        int counterNames = 0;

        while (!name.equals("Finish")) {
            counterNames++;

            double sumGrade = 0;
            for (int i = 0; i < n; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                sumGrade += grade;
            }

            averageGrade = sumGrade / n;
            System.out.printf("%s - %.2f.%n", name, averageGrade);

            allGrades += sumGrade;
            name = scanner.nextLine();
        }

        allGrades = allGrades / (n * counterNames);
        System.out.printf("Student's final assessment is %.2f.", allGrades);
    }
}
