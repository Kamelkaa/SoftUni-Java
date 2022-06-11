package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Task_05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];

        String[][] matrix = getMatrix(rows, cols, scanner, "\\s+");
        String command = scanner.nextLine();

        while (!command.equals("END")) {
            if (commandIsValid(command, rows, cols)) {
                String[] tokens = command.split("\\s+");
                int firstRow = Integer.parseInt(tokens[1]);
                int firstCol = Integer.parseInt(tokens[2]);
                int secondRow = Integer.parseInt(tokens[3]);
                int secondCol = Integer.parseInt(tokens[4]);

                String elementOne = matrix[firstRow][firstCol];
                String elementTwo = matrix[secondRow][secondCol];

                matrix[firstRow][firstCol] = elementTwo;
                matrix[secondRow][secondCol] = elementOne;

                printMatrix(rows, cols, matrix);
            } else {
                System.out.println("Invalid input!");
            }


            command = scanner.nextLine();
        }

    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean commandIsValid(String command, int rows, int cols) {
        String[] currentCommand = command.split("\\s+");
        String commandName = currentCommand[0];

        if (currentCommand.length != 5) {
            return false;
        }

        if (!commandName.equals("swap")) {
            return false;
        }

        int firstRow = Integer.parseInt(currentCommand[1]);
        int firstCol = Integer.parseInt(currentCommand[2]);
        int secondRow = Integer.parseInt(currentCommand[3]);
        int secondCol = Integer.parseInt(currentCommand[4]);

        if (firstRow < 0 || firstRow >= rows || firstCol < 0 || firstCol >= cols
                || secondRow < 0 || secondRow >= rows || secondCol < 0 || secondCol >= cols) {
            return false;
        }

        return true;
    }

    private static String[][] getMatrix(int rows, int cols, Scanner scanner, String pattern) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(pattern);
        }

        return matrix;
    }
}
