package exam05_26Oct2019;

import java.util.Scanner;

public class Problem_02_BookWorm {
    static int startRow;
    static int startCol;
    static String theString;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        theString = scanner.nextLine();

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("P")) {
                startRow = row;
                startCol = line.indexOf("P");
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if ("up".equals(command)) {
                move(startRow - 1, startCol, matrix, command);
            } else if ("down".equals(command)) {
                move(startRow + 1, startCol, matrix, command);
            } else if ("left".equals(command)) {
                move(startRow, startCol - 1, matrix, command);
            } else if ("right".equals(command)) {
                move(startRow, startCol + 1, matrix, command);
            }

            command = scanner.nextLine();
        }
        System.out.println(theString);
        printMatrix(matrix);
    }

    private static void move(int newRow, int newCol, char[][] matrix, String command) {
        matrix[startRow][startCol] = '-';

        if (isOutOdBounds(newRow, newCol, matrix)) {
            if (theString.length() > 0) {
                theString = theString.substring(0, theString.length() - 1);
            }
            matrix[startRow][startCol] = 'P';
            return;
        }

        char symbol = matrix[newRow][newCol];
        if (symbol != '-') {
            theString += symbol;
        }

        matrix[newRow][newCol] = 'P';
        startRow = newRow;
        startCol = newCol;
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
