package Lab;

import java.util.*;

public class Task_06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowCol = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(rowCol, scanner, "\\s+");

        printFirstDiagonal(matrix, rowCol);
        printSecondDiagonal(matrix, rowCol);
    }

    private static int[][] readMatrix(int rowCol, Scanner scanner, String pattern) {
        int[][] matrix = new int[rowCol][rowCol];

        for (int i = 0; i < rowCol; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(pattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static void printFirstDiagonal(int[][] matrix, int rowCol) {
        for (int i = 0; i < rowCol; i++) {
            for (int j = 0; j < rowCol; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }

        System.out.println();
    }

    private static void printSecondDiagonal(int[][] matrix, int rowCol) {
        ArrayDeque<Integer> secondDiagonal = new ArrayDeque<>();

        for (int i = 0; i < rowCol; i++) {
            for (int j = 0; j < rowCol; j++) {
                if (i + j == rowCol - 1) {
                    secondDiagonal.push(matrix[i][j]);
                }
            }
        }

        while (!secondDiagonal.isEmpty()) {
            System.out.printf("%d ", secondDiagonal.pop());
        }
    }
}
