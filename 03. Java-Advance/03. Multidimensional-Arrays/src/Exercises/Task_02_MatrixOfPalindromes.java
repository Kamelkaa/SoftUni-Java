package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Task_02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];

        String[][] matrix = getMatrixOfPalindromes(rows, cols);
        printMatrix(matrix);
    }

    private static String[][] getMatrixOfPalindromes(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        char startLetter = 'a';

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String palindrome = "" + startLetter + (char) (startLetter + col) + startLetter;
                matrix[row][col] = palindrome;
            }
            startLetter = (char) (startLetter + 1);
        }

        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element + " ");
            }

            System.out.println();
        }
    }
}
