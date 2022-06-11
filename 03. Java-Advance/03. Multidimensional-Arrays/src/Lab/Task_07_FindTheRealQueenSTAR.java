package Lab;

import java.util.Scanner;

public class Task_07_FindTheRealQueenSTAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 8;
        char[][] matrix = readMatrix(n, scanner, "\\s+");

        int[] positionOfRealQueen = new int[2];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'q') {
                    if (isTheRealQueen(i, j, matrix)) {
                        positionOfRealQueen = new int[]{i, j};
                        break;
                    }
                }
            }
        }

        for (int element : positionOfRealQueen) {
            System.out.print(element + " ");
        }
    }

    private static boolean isTheRealQueen(int row, int col, char[][] matrix) {
        boolean isTheRealQueen = true;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {    //left up diagonal
            if (matrix[i][j] == 'q') {
                isTheRealQueen = false;
                break;
            }
        }

        for (int i = row + 1, j = col - 1; i < matrix.length && j >= 0; i++, j--) {  //left down diagonal
            if (matrix[i][j] == 'q') {
                isTheRealQueen = false;
                break;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < matrix.length; i--, j++) {  //right up diagonal
            if (matrix[i][j] == 'q') {
                isTheRealQueen = false;
                break;
            }
        }

        for (int i = row + 1, j = col + 1; i < matrix.length && j < matrix.length; i++, j++) {  //right down diagonal
            if (matrix[i][j] == 'q') {
                isTheRealQueen = false;
                break;
            }
        }

        for (int i = row - 1; i >= 0; i--) {  //same col up
            if (matrix[i][col] == 'q') {
                isTheRealQueen = false;
                break;
            }
        }

        for (int i = row + 1; i < matrix.length; i++) {  //same col down
            if (matrix[i][col] == 'q') {
                isTheRealQueen = false;
                break;
            }
        }

        for (int i = col - 1; i >= 0; i--) {  //same row left
            if (matrix[row][i] == 'q') {
                isTheRealQueen = false;
                break;
            }
        }

        for (int i = col + 1; i < matrix.length; i++) {  //same row down
            if (matrix[row][i] == 'q') {
                isTheRealQueen = false;
                break;
            }
        }
        return isTheRealQueen;
    }

    private static char[][] readMatrix(int n, Scanner scanner, String pattern) {
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(pattern);
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }

        return matrix;
    }
}
