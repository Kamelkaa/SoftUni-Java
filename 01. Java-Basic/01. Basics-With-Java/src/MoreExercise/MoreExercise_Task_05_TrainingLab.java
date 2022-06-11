package MoreExercise;

import java.util.Scanner;

public class MoreExercise_Task_05_TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double lengthW = Double.parseDouble(scanner.nextLine());
        double wightH = Double.parseDouble(scanner.nextLine());

        double wightWithoutCorridor = wightH * 100 - 100;
        double place = Math.floor(wightWithoutCorridor / 70);
        double rows = Math.floor(lengthW * 100 / 120);

        double numberOfPlaces = place * rows - 3;

        System.out.printf("%.0f", numberOfPlaces);
    }
}
