package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine().split("[()]+")[1]) % 360;

        String input = scanner.nextLine();
        List<String> matrixLines = new ArrayList<>();
        int maxLength = input.length();

        while (!input.equals("END")) {
            if (input.length() > maxLength) {
                maxLength = input.length();
            }

            matrixLines.add(input);

            input = scanner.nextLine();
        }

        int rows = matrixLines.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < matrixLines.get(row).length()) {
                    matrix[row][col] = matrixLines.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        if (degrees == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 0) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
