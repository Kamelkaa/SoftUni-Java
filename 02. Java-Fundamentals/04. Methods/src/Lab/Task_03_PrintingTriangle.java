package Lab;

import java.util.Scanner;

public class Task_03_PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());

        printTriangle(height);
    }

    private static void printTriangle(int height) {
        printTopHalfOfTriangle(height);
        printBottomHalfOfTriangle(height);
    }

    private static void printTopHalfOfTriangle(int height) {
        for (int i = 0; i <= height; i++) {
            printSingleLine(i);
        }
    }

    private static void printBottomHalfOfTriangle(int height) {
        for (int i = height - 1; i >= 1; i--) {
            printSingleLine(i);
        }
    }

    private static void printSingleLine(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
