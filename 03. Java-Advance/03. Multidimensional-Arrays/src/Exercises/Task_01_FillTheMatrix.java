package Exercises;

import java.util.Scanner;

public class Task_01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] matrix = new int[size][size];

        switch (type) {
            case "A":
                fillMatrixByAType(matrix, size);
                break;
            case "B":
                fillMatrixbyBtype(matrix, size);
                break;
        }

        printMatrix(matrix);
    }

    private static void fillMatrixByAType(int[][] matrix, int size) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[row][col] = startNumber++;
            }
        }
    }

    private static void fillMatrixbyBtype(int[][] matrix, int size) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix[col].length; row++) {
                    matrix[row][col] = startNumber++;
                }
            } else {
                for (int row = matrix[col].length - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
