package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Task_04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        int sizeSubMatrix = 3;

        int[][] matrix = getMatrix(rows, cols, scanner, "\\s+");

        int maxSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;

        for (int firstRow = 0; firstRow < matrix.length - (sizeSubMatrix - 1); firstRow++) {
            for (int firstCol = 0; firstCol < matrix[firstRow].length - (sizeSubMatrix - 1); firstCol++) {
                int sum = 0;
                for (int row = 0; row < sizeSubMatrix; row++) {
                    for (int col = 0; col < sizeSubMatrix; col++) {
                        sum += matrix[firstRow + row][firstCol + col];

                        if (maxSum < sum) {
                            maxSum = sum;
                            bestRow = firstRow;
                            bestCol = firstCol;
                        }
                    }
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        printSubMatrixMaxSum3x3(bestRow, bestCol, sizeSubMatrix, matrix);
    }

    private static int[][] getMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(pattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static void printSubMatrixMaxSum3x3(int bestRow, int bestCol, int sizeSubMatrix, int[][] matrix) {
        for (int row = bestRow; row < bestRow + sizeSubMatrix; row++) {
            for (int col = bestCol; col < bestCol + sizeSubMatrix; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}