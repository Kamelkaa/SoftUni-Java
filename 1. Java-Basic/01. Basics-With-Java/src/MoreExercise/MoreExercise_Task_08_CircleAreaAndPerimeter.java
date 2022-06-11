package MoreExercise;

import java.util.Scanner;

public class MoreExercise_Task_08_CircleAreaAndPerimeter {
    public static void main(String[] args) {
        //радиус
        //Лице = π * r * r
        //Периметър = 2 * π * r
        Scanner scanner = new Scanner(System.in);

        double radius = Double.parseDouble(scanner.nextLine());
        double area = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius;

        System.out.printf("%.2f%n%.2f", area, perimeter);
    }
}

