package Exercise;

import java.util.Scanner;

public class Task_08_OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hourExam = Integer.parseInt(scanner.nextLine());
        int minutesExam = Integer.parseInt(scanner.nextLine());
        int hourArrival = Integer.parseInt(scanner.nextLine());
        int minutesArrival = Integer.parseInt(scanner.nextLine());

        int totalTimeExamMin = hourExam * 60 + minutesExam;
        int totalTimeArrivalMin = hourArrival * 60 + minutesArrival;


        if (totalTimeArrivalMin > totalTimeExamMin) {
            System.out.println("Late");
            int lateTime = totalTimeArrivalMin - totalTimeExamMin;

            if (lateTime < 60) {
                System.out.printf("%d minutes after the start", lateTime);
            } else {
                int hour = lateTime / 60;
                int minutes = lateTime % 60;
                System.out.printf("%d:%02d hours after the start", hour, minutes);
            }
        }
        else if (totalTimeArrivalMin == totalTimeExamMin || totalTimeExamMin - totalTimeArrivalMin <= 30) {
            System.out.println("On time");

            if (totalTimeArrivalMin != totalTimeExamMin && totalTimeExamMin - totalTimeArrivalMin <= 30) {
                System.out.printf("%d minutes before the start", totalTimeExamMin - totalTimeArrivalMin);
            }
        }
        else if (totalTimeExamMin - totalTimeArrivalMin > 30) {
            System.out.println("Early");
            int earlyTime = totalTimeExamMin - totalTimeArrivalMin;

            if (earlyTime < 60) {
                System.out.printf("%d minutes before the start", earlyTime);
            } else {
                int hour = earlyTime / 60;
                int minutes = earlyTime % 60;
                System.out.printf("%d:%02d hours before the start", hour, minutes);
            }
        }
    }
}
