package MoreExercise;

import java.util.Scanner;

public class Task_02_Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberDays = Integer.parseInt(scanner.nextLine());

        int treated = 0;
        int untreated = 0;
        int numbersDoc = 7;

        for (int i = 1; i <= numberDays; i++) {
            int numberPatient = Integer.parseInt(scanner.nextLine());

            if (i % 3 == 0 && untreated > treated) {
                numbersDoc++;
            }

            if (numberPatient <= numbersDoc) {
                treated = treated + numberPatient;
            } else {
                untreated = untreated + numberPatient - numbersDoc;
                treated = treated + numbersDoc;
            }
        }

        System.out.printf("Treated patients: %d.%n" +
                "Untreated patients: %d.", treated, untreated);
    }
}
