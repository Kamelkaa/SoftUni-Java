package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task_05_MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rowsAndCols = scanner.nextLine();

        int[] array = getArray(rowsAndCols, ", ");
        int rows = array[0];
        int cols = array[1];
        int[][] matrix = getMatrix(rows, cols, scanner, ", ");

        int[][] subMatrixOfMaxSum = getSubMatrixOfMaxSum(matrix);
        int sum = getMatrixSum(subMatrixOfMaxSum);

        readMatrix(subMatrixOfMaxSum);
        System.out.printf("%d", sum);
    }

    private static int[] getArray(String rowsAndCols, String pattern) {
        return Arrays.stream(rowsAndCols.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] getMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = getArray(scanner.nextLine(), pattern);
        }

        return matrix;
    }

    private static int[][] getSubMatrixOfMaxSum(int[][] matrix) {
        int maxSum = 0;
        int rowBest = 0;
        int colBest = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int sum =
                        matrix[i][j] + matrix[i][j + 1]
                      + matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    rowBest = i;
                    colBest = j;
                }
            }
        }

        return new int[][]{
                {matrix[rowBest][colBest], matrix[rowBest][colBest + 1]},
                {matrix[rowBest + 1][colBest], matrix[rowBest + 1][colBest + 1]}
        };
    }

    private static int getMatrixSum(int[][] subMatrixOfMaxSum) {
        int sum = 0;

        for (int[] arr : subMatrixOfMaxSum) {
            for (int element : arr) {
                sum += element;
            }
        }

        return sum;
    }

    private static void readMatrix(int[][] subMatrixOfMaxSum) {
        for (int[] arr : subMatrixOfMaxSum) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
