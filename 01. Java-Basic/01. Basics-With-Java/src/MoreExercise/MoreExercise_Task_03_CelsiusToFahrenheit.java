package MoreExercise;

import java.util.Scanner;

public class MoreExercise_Task_03_CelsiusToFahrenheit {
    public static void main(String[] args) {
        //°F = °C × 1.8 + 32
        Scanner scanner = new Scanner(System.in);

        double celsius = Double.parseDouble(scanner.nextLine());
        double fahrenheit = celsius * 1.8 + 32;

        System.out.printf("%.2f", fahrenheit);
    }
}
