package Lab;

import java.util.Scanner;

public class Task_03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int colons = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrixChar(rows, colons, scanner);
        char[][] secondMatrix = readMatrixChar(rows, colons, scanner);

        char[][] intersectionMatrix = getIntersectionMatrix(firstMatrix, secondMatrix);
        printMatrixChar(intersectionMatrix);
    }

    private static char[][] readMatrixChar(int rows, int colons, Scanner scanner) {
        char[][] matrix = new char[rows][colons];

        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }

        return matrix;
    }

    private static char[][] getIntersectionMatrix(char[][] firstMatrix, char[][] secondMatrix) {
        char[][] matrix = new char[firstMatrix.length][];

        for (int i = 0; i < firstMatrix.length; i++) {
            matrix[i] = new char[firstMatrix[i].length];
            for (int j = 0; j < firstMatrix[i].length; j++) {
                matrix[i][j] = firstMatrix[i][j] == secondMatrix[i][j]
                        ? firstMatrix[i][j]
                        : '*';
            }
        }

        return matrix;
    }

    private static void printMatrixChar(char[][] intersectionMatrix) {
        for (char[] array : intersectionMatrix) {
            for (char element : array) {
                System.out.print(element + " ");
            }

            System.out.println();
        }
    }
}
