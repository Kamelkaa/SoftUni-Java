package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task_02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rowsAndColons = scanner.nextLine();
        int[] array = readArray(rowsAndColons, "\\s+");

        int rows = array[0];
        int colons = array[1];
        int[][] matrix = readMatrix(rows, colons, scanner, "\\s+");

        int number = Integer.parseInt(scanner.nextLine());

        List<int[]> positions = findPositions(number, matrix);

        if (positions.isEmpty()) {
            System.out.println("not found");
        } else {
            printList(positions);
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

    private static List<int[]> findPositions(int number, int[][] matrix) {
        List<int[]> positionsOfNumber = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int currentNumber = matrix[i][j];
                if (currentNumber == number) {
                    positionsOfNumber.add(new int[]{i, j});
                }
            }
        }

        return positionsOfNumber;
    }

    private static void printList(List<int[]> positions) {
        for (int[] arr : positions) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
