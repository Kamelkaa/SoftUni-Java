package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task_01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rowsAndColonsOne = scanner.nextLine();
        int[] firstArray = readArray(rowsAndColonsOne, "\\s+");

        int rowsForFirstMatrix = firstArray[0];
        int colonsForFirstMatrix = firstArray[1];
        int[][] firstMatrix = readMatrix(rowsForFirstMatrix, colonsForFirstMatrix, scanner, "\\s+");

        String rowsAndColonsTwo = scanner.nextLine();
        int[] secondArray = readArray(rowsAndColonsTwo, "\\s+");

        int rowsForSecondMatrix = secondArray[0];
        int colonsForSecondMatrix = secondArray[1];
        int[][] secondMatrix = readMatrix(rowsForSecondMatrix, colonsForSecondMatrix, scanner, "\\s+");

        if (isEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static int[] readArray(String rowsAndColons, String pattern) {
        return Arrays.stream(rowsAndColons.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] readMatrix(int rows, int colons, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][colons];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner.nextLine(), pattern);
        }

        return matrix;
    }

    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArray = firstMatrix[row];
            int[] secondArray = secondMatrix[row];

            if (firstArray.length != secondArray.length) {
                return false;
            }

            for (int colons = 0; colons < firstArray.length; colons++) {
                if (firstArray[colons] != secondArray[colons]) {
                    return false;
                }
            }
        }

        return true;
    }
}
