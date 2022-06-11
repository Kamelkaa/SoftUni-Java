package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Task_03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = getMatrix(size, scanner, "\\s+");

        int sumOfPrimaryDiagonal = getSumOfPrimaryDiagonal(matrix);
        int sumOfSecondaryDiagonal = getSumOfSecondaryDiagonal(matrix);

        System.out.println(Math.abs(sumOfPrimaryDiagonal - sumOfSecondaryDiagonal));
    }

    private static int[][] getMatrix(int size, Scanner scanner, String pattern) {
        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(pattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static int getSumOfPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }

        return sum;
    }

    private static int getSumOfSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row + col == matrix.length - 1) {
                    sum += matrix[row][col];
                }
            }
        }

        return sum;
    }
}
