package exam03_28June2020;

import java.util.Scanner;

public class Problem_02_Snake {
    static int startRow;
    static int startCol;
    static int foodQuantity = 0;
    static boolean isOnTerritory = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("S")) {
                startRow = row;
                startCol = line.indexOf("S");
            }
        }

        while (foodQuantity < 10) {
            String command = scanner.nextLine();
            if (command.equals("up")) {
                move(startRow - 1, startCol, matrix);
            } else if (command.equals("down")) {
                move(startRow + 1, startCol, matrix);
            } else if (command.equals("left")) {
                move(startRow, startCol - 1, matrix);
            } else if (command.equals("right")) {
                move(startRow, startCol + 1, matrix);
            }

            if (!isOnTerritory) {
                break;
            }
        }

        String message = !isOnTerritory
                ? "Game over!"
                : "You won! You fed the snake.";
        System.out.println(message);
        System.out.printf("Food eaten: %d%n", foodQuantity);
        printMatrix(matrix);

    }

    private static void move(int newRow, int newCol, char[][] matrix) {
        matrix[startRow][startCol] = '.';

        if (isOutOdBounds(newRow, newCol, matrix)) {
            isOnTerritory = false;
            return;
        }

        char symbol = matrix[newRow][newCol];
        if (symbol == '*') {
            foodQuantity++;
        } else if (symbol == 'B') {
            matrix[newRow][newCol] = '.';
            int[] secondBurrowLocation = findSecondBurrow(matrix);
            newRow = secondBurrowLocation[0];
            newCol = secondBurrowLocation[1];
        }

        matrix[newRow][newCol] = 'S';
        startRow = newRow;
        startCol = newCol;
    }

    private static int[] findSecondBurrow(char[][] matrix) {
        int[] indexes = null;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'B') {
                    indexes = new int[]{r, c};
                    break;
                }
            }
            if (indexes != null) {
                break;
            }
        }
        return indexes;
    }

    private static boolean isOutOdBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
