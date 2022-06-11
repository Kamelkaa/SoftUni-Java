package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task_04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rowsAndCols = scanner.nextLine();
        int[] array = readArray(rowsAndCols, ", ");
        int rows = array[0];
        int cols = array[1];

        int[][] matrix = readMatrix(rows, cols, scanner, ", ");
        int sum = getSumOfMatrixElements(matrix);

        System.out.printf("%d%n%d%n%d", rows, cols, sum);
    }

    private static int[] readArray(String rowsAndCols, String pattern) {
        return Arrays.stream(rowsAndCols.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner.nextLine(), pattern);
        }

        return matrix;
    }

    private static int getSumOfMatrixElements(int[][] matrix) {
        int sum = 0;

        for (int[] arr : matrix) {
            for (int element : arr) {
                sum += element;
            }
        }

        return sum;
    }
}
