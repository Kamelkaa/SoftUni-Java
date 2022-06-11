package exam02_19August2020;

import java.util.Scanner;

public class Problem_02_Bee {
    static int startRow;
    static int startCol;
    static int pollinatedFlower = 0;
    static boolean isOnTerritory = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("B")) {
                startRow = row;
                startCol = line.indexOf("B");
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            if ("up".equals(command)) {
                move(startRow - 1, startCol, matrix, command);
            } else if ("down".equals(command)) {
                move(startRow + 1, startCol, matrix, command);
            } else if ("left".equals(command)) {
                move(startRow, startCol - 1, matrix, command);
            } else if ("right".equals(command)) {
                move(startRow, startCol + 1, matrix, command);
            }

            if (!isOnTerritory) {
                break;
            }
            command = scanner.nextLine();
        }

        if (!isOnTerritory) {
            System.out.println("The bee got lost!");
        }
        if (pollinatedFlower >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlower);
        } else {
            int neededFlowers = 5 - pollinatedFlower;
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", neededFlowers);
        }
        printMatrix(matrix);
    }

    private static void move(int newRow, int newCol, char[][] matrix, String command) {
        matrix[startRow][startCol] = '.';

        if (isOutOdBounds(newRow, newCol, matrix)) {
            isOnTerritory = false;
            return;
        }

        char symbol = matrix[newRow][newCol];
        if (symbol == 'f') {
            pollinatedFlower++;
        } else if (symbol == 'O') {
            matrix[newRow][newCol] = '.';
            int[] secondPosition = findSecondPosition(command);
            char nextSymbol = matrix[secondPosition[0]][secondPosition[1]];
            if (nextSymbol == 'f') {
                pollinatedFlower++;
            }
            matrix[secondPosition[0]][secondPosition[1]] = 'B';
            startRow = secondPosition[0];
            startCol = secondPosition[1];
            return;
        }

        matrix[newRow][newCol] = 'B';
        startRow = newRow;
        startCol = newCol;
    }

    private static int[] findSecondPosition(String command) {
        int[] indexes = null;
        switch (command) {
            case "up":
                indexes = new int[]{startRow - 2, startCol};
                break;
            case "down":
                indexes = new int[]{startRow + 2, startCol};
                break;
            case "left":
                indexes = new int[]{startRow, startCol - 2};
                break;
            case "right":
                indexes = new int[]{startRow, startCol + 2};
                break;
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

