package Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Task_11_ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];

        int[][] matrix = readMatrix(rows, cols, scanner);

        ArrayDeque<Integer> integers = new ArrayDeque<>();
        for (int row = 0; row < rows; row++) {
            int count = 0;
            while (isValid(row - count, count, matrix)) {
                int tempRow = row - count;
                integers.offer(matrix[tempRow][count]);
                count++;
            }
        }

        for (int col = 1; col < cols; col++) {
            int r = matrix.length - 1;
            int count = 0;
            while (isValid(r - count, col + count, matrix)) {
                int tempCol = col + count;
                int tempRow = r - count;
                integers.offer(matrix[tempRow][tempCol]);
                count++;
            }
        }

        int[][] newMatrix = new int[cols + rows - 1][];
        int count = 1;

        for (int row = cols + rows - 2; row >= 0; row--) {
            int[] arr = new int[count];
            for (int i = 0; i < count; i++) {
                arr[i] = integers.poll();
            }

            newMatrix[row] = arr;
            if (count < matrix.length && row > matrix.length - 1) {
                count++;
            } else if (row < matrix.length) {
                count--;
            }
        }

        printMatrix(newMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int row, int col, int[][] chamber) {
        return row >= 0 && col >= 0 && row < chamber.length && col < chamber[row].length;
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }
}
