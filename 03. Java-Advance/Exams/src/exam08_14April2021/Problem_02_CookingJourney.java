package exam08_14April2021;

import java.util.Scanner;

public class Problem_02_CookingJourney {
    static int startRow;
    static int startCol;
    static int money = 0;

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

        boolean isInPastry = true;
        while (money < 50 && isInPastry) {
            String command = scanner.nextLine();
            if (command.equals("up")) {
                isInPastry = move(startRow - 1, startCol, matrix);
            } else if (command.equals("down")) {
                isInPastry = move(startRow + 1, startCol, matrix);
            } else if (command.equals("left")) {
                isInPastry = move(startRow, startCol - 1, matrix);
            } else if (command.equals("right")) {
                isInPastry = move(startRow, startCol + 1, matrix);
            }
        }

        String massage = !isInPastry
                ? "Bad news! You are out of the pastry shop."
                : "Good news! You succeeded in collecting enough money!";
        System.out.println(massage);
        System.out.println("Money: " + money);
        printMatrix(matrix);
    }

    private static boolean move(int newRow, int newCol, char[][] matrix) {
        matrix[startRow][startCol] = '-';

        if (isOutOdBounds(newRow, newCol, matrix)) {
            return false;
        }

        char symbol = matrix[newRow][newCol];
        if (Character.isDigit(symbol)) {
            money += symbol - '0';
        } else if (symbol == 'P') {
            matrix[newRow][newCol] = '-';
            int[] secondPillarLocation = findSecondPillar(matrix);
            newRow = secondPillarLocation[0];
            newCol = secondPillarLocation[1];
        }

        matrix[newRow][newCol] = 'S';
        startRow = newRow;
        startCol = newCol;

        return true;
    }

    public static int[] findSecondPillar(char[][] matrix) {
        int[] indexes = null;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'P') {
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
