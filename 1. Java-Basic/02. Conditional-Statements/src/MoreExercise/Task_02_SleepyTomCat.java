package MoreExercise;

import java.util.Scanner;

public class Task_02_SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int holidays = Integer.parseInt(scanner.nextLine());

        int workingDays = 365 - holidays;
        int realTimeToPlay = workingDays * 63 + holidays * 127;

        if (realTimeToPlay > 30000) {

            int difference = realTimeToPlay - 30000;
            int hours = difference / 60;
            int minutes = difference % 60;

            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", hours, minutes);

        } else {

            int difference = 30000 - realTimeToPlay;
            int hours = difference / 60;
            int minutes = difference % 60;

            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hours, minutes);

        }
    }
}
