package exam01_16December2020;

import java.util.Scanner;

public class Problem_02_Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrixBakery = getMatrix(size, scanner);

        int rent = 0;
        boolean isOnBakery = true;

        while (isOnBakery && rent < 50) {
            boolean ifFindS = false;
            String command = scanner.nextLine();
            for (int row = 0; row < matrixBakery.length; row++) {
                if (!isOnBakery) {
                    break;
                }
                if (ifFindS) {
                    break;
                }
                for (int col = 0; col < matrixBakery.length; col++) {

                    if (matrixBakery[row][col].equals("S")) {
                        if (command.equals("up")) {
                            if (isNotInBounds(row - 1, col, matrixBakery)) {
                                matrixBakery[row][col] = "-";
                                isOnBakery = false;
                                break;
                            }
                            if (Character.isDigit(matrixBakery[row - 1][col].charAt(0))) {
                                rent += Integer.parseInt(matrixBakery[row - 1][col]);
                                matrixBakery[row][col] = "-";
                                matrixBakery[row - 1][col] = "S";
                                ifFindS = true;
                                break;
                            } else if (matrixBakery[row - 1][col].equals("O")) {
                                matrixBakery[row - 1][col] = "-";
                                for (int i = 0; i < matrixBakery.length; i++) {
                                    for (int j = 0; j < matrixBakery.length; j++) {
                                        if (matrixBakery[i][j].equals("O")) {
                                            matrixBakery[i][j] = "S";
                                        }
                                    }
                                }
                                matrixBakery[row][col] = "-";
                                ifFindS = true;
                                break;
                            } else {
                                matrixBakery[row][col] = "-";
                                matrixBakery[row - 1][col] = "S";
                                ifFindS = true;
                                break;
                            }
                        } else if (command.equals("down")) {
                            if (isNotInBounds(row + 1, col, matrixBakery)) {
                                matrixBakery[row][col] = "-";
                                isOnBakery = false;
                                break;
                            }
                            if (Character.isDigit(matrixBakery[row + 1][col].charAt(0))) {
                                rent += Integer.parseInt(matrixBakery[row + 1][col]);
                                matrixBakery[row][col] = "-";
                                matrixBakery[row + 1][col] = "S";
                                ifFindS = true;
                                break;
                            } else if (matrixBakery[row + 1][col].equals("O")) {
                                matrixBakery[row + 1][col] = "-";
                                for (int i = 0; i < matrixBakery.length; i++) {
                                    for (int j = 0; j < matrixBakery.length; j++) {
                                        if (matrixBakery[i][j].equals("O")) {
                                            matrixBakery[i][j] = "S";
                                        }
                                    }
                                }
                                matrixBakery[row][col] = "-";
                                ifFindS = true;
                                break;
                            } else {
                                matrixBakery[row][col] = "-";
                                matrixBakery[row + 1][col] = "S";
                                ifFindS = true;
                                break;
                            }
                        } else if (command.equals("left")) {
                            if (isNotInBounds(row, col - 1, matrixBakery)) {
                                matrixBakery[row][col] = "-";
                                isOnBakery = false;
                                break;
                            }
                            if (Character.isDigit(matrixBakery[row][col - 1].charAt(0))) {
                                rent += Integer.parseInt(matrixBakery[row][col - 1]);
                                matrixBakery[row][col] = "-";
                                matrixBakery[row][col - 1] = "S";
                                ifFindS = true;
                                break;
                            } else if (matrixBakery[row][col - 1].equals("O")) {
                                matrixBakery[row][col - 1] = "-";
                                for (int i = 0; i < matrixBakery.length; i++) {
                                    for (int j = 0; j < matrixBakery.length; j++) {
                                        if (matrixBakery[i][j].equals("O")) {
                                            matrixBakery[i][j] = "S";
                                        }
                                    }
                                }
                                matrixBakery[row][col] = "-";
                                ifFindS = true;
                                break;
                            } else {
                                matrixBakery[row][col] = "-";
                                matrixBakery[row - 1][col] = "S";
                                ifFindS = true;
                                break;
                            }
                        } else if (command.equals("right")) {
                            if (isNotInBounds(row, col + 1, matrixBakery)) {
                                matrixBakery[row][col] = "-";
                                isOnBakery = false;
                                break;
                            }
                            if (Character.isDigit(matrixBakery[row][col + 1].charAt(0))) {
                                rent += Integer.parseInt(matrixBakery[row][col + 1]);
                                matrixBakery[row][col] = "-";
                                matrixBakery[row][col + 1] = "S";
                                ifFindS = true;
                                break;
                            } else if (matrixBakery[row][col + 1].equals("O")) {
                                matrixBakery[row][col + 1] = "-";
                                for (int i = 0; i < matrixBakery.length; i++) {
                                    for (int j = 0; j < matrixBakery.length; j++) {
                                        if (matrixBakery[i][j].equals("O")) {
                                            matrixBakery[i][j] = "S";
                                        }
                                    }
                                }
                                matrixBakery[row][col] = "-";
                                ifFindS = true;
                                break;
                            } else {
                                matrixBakery[row][col] = "-";
                                matrixBakery[row + 1][col] = "S";
                                ifFindS = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        if (!isOnBakery) {
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + rent);
        printMatrix(matrixBakery);
    }

    private static void printMatrix(String[][] matrixBakery) {
        for (String[] arr : matrixBakery) {
            for (String element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    public static boolean isNotInBounds(int row, int col, String[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static String[][] getMatrix(int size, Scanner scanner) {
        String[][] matrix = new String[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
        return matrix;
    }
}