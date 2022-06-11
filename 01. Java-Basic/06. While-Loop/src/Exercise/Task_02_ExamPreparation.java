package Exercise;

import java.util.Scanner;

public class Task_02_ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int badAssessments = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String lastNameProblem = "";
        double sum = 0;
        int counterBadAssessments = 0;
        int counterResolveProblems = 0;
        boolean isBad = false;

        while (!input.equals("Enough")) {
            lastNameProblem = input;
            int grade = Integer.parseInt(scanner.nextLine());

            if (grade <= 4) {
                counterBadAssessments++;

                if (counterBadAssessments == badAssessments) {
                    isBad = true;
                    System.out.printf("You need a break, %d poor grades.", counterBadAssessments);
                    break;
                }
            }

            counterResolveProblems++;
            sum += grade;
            input = scanner.nextLine();
        }

        if (!isBad) {
            double averageSum = sum / counterResolveProblems;
            System.out.printf("Average score: %.2f%n" +
                            "Number of problems: %d%n" +
                            "Last problem: %s",
                    averageSum, counterResolveProblems, lastNameProblem);
        }
    }
}
