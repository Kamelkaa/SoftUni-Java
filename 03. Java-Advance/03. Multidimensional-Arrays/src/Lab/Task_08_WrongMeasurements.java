package Lab;

import java.util.*;

public class Task_08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int[][] matrix = getMatrix(row, 0, scanner, "\\s+");

        int[] coordinates = getArray(scanner, "\\s+");
        int mistakenValue = matrix[coordinates[0]][coordinates[1]];

        List<int[]> newValues = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == mistakenValue) {
                    newValues.add(new int[]{i, j, getSumOfClosestItems(i, j, mistakenValue, matrix)});
                }
            }
        }

        for (int[] values : newValues) {
            matrix[values[0]][values[1]] = values[2];
        }

        printMatrix(matrix);
        System.out.println();
    }

    private static int[][] getMatrix(int row, int col, Scanner scanner, String pattern) {
        int[][] matrix = new int[row][col];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = getArray(scanner, "\\s+");
        }

        return matrix;
    }

    private static int[] getArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int getSumOfClosestItems(int i, int j, int mistakenValue, int[][] matrix) {
        int sum = 0;

        if (isInBounds(i, j + 1, matrix) && matrix[i][j + 1] != mistakenValue) {
            sum += matrix[i][j + 1];
        }
        if (isInBounds(i, j - 1, matrix) && matrix[i][j - 1] != mistakenValue) {
            sum += matrix[i][j - 1];
        }
        if (isInBounds(i + 1, j, matrix) && matrix[i + 1][j] != mistakenValue) {
            sum += matrix[i + 1][j];
        }
        if (isInBounds(i - 1, j, matrix) && matrix[i - 1][j] != mistakenValue) {
            sum += matrix[i - 1][j];
        }

        return sum;
    }

    public static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }


    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
    }
}
