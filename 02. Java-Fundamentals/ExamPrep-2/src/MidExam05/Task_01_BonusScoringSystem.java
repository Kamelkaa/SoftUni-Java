package MidExam05;

import java.util.Scanner;

public class Task_01_BonusScoringSystem {

    public static void main(String[] args) {
        //{total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})
        Scanner scanner = new Scanner(System.in);

        int countOfStudents = Integer.parseInt(scanner.nextLine());
        int countOfLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int maxAttendance = 0;

        for (int i = 0; i < countOfStudents; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());

            double totalBonus = (1.0 * attendance / countOfLectures) * (5 + additionalBonus);

            if (maxBonus < totalBonus) {
                maxBonus = totalBonus;
                maxAttendance = attendance;
            }
        }


        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", maxAttendance);

    }
}
