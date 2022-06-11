package exam06_23Oct2019;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem_01_TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.split("\\s+");
        }

        Map<String, Integer> vegetables = new LinkedHashMap<>();
        vegetables.put("Carrots", 0);
        vegetables.put("Potatoes", 0);
        vegetables.put("Lettuce", 0);
        int harmedVegetables = 0;

        String input = scanner.nextLine();
        while (!input.equals("End of Harvest")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            if (command.equals("Harvest")) {
                if (!isOutOdBounds(row, col, matrix)) {
                    String currentLetter = matrix[row][col];
                    vegetables = getVegetables(currentLetter, vegetables);
                    matrix[row][col] = " ";
                }
            } else if (command.equals("Mole")) {
                if (!isOutOdBounds(row, col, matrix)) {
                    String direction = tokens[3];

                    switch (direction) {
                        case "up":
                            for (int i = row; row >= 0; row -= 2) {
                                if (!isOutOdBounds(row, col, matrix)) {
                                    if (!matrix[row][col].equals(" ")) {
                                        matrix[row][col] = " ";
                                        harmedVegetables++;
                                    }
                                }
                            }
                            break;
                        case "down":
                            for (int i = row; row < matrix.length; row += 2) {
                                if (!isOutOdBounds(row, col, matrix)) {
                                    if (!matrix[row][col].equals(" ")) {
                                        matrix[row][col] = " ";
                                        harmedVegetables++;
                                    }
                                }
                            }
                            break;
                        case "left":
                            for (int i = col; col >= 0; col -= 2) {
                                if (!isOutOdBounds(row, col, matrix)) {
                                    if (!matrix[row][col].equals(" ")) {
                                        matrix[row][col] = " ";
                                        harmedVegetables++;
                                    }
                                }
                            }
                            break;
                        case "right":
                            for (int i = col; col < matrix[row].length; col += 2) {
                                if (!isOutOdBounds(row, col, matrix)) {
                                    if (!matrix[row][col].equals(" ")) {
                                        matrix[row][col] = " ";
                                        harmedVegetables++;
                                    }
                                }
                            }
                            break;
                    }
                }
            }

            input = scanner.nextLine();
        }

        printMatrix(matrix);
        vegetables.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
        System.out.printf("Harmed vegetables: %d", harmedVegetables);
    }


    private static Map<String, Integer> getVegetables(String currentLetter, Map<String, Integer> vegetables) {
        switch (currentLetter) {
            case "C":
                vegetables.put("Carrots", vegetables.get("Carrots") + 1);
                break;
            case "P":
                vegetables.put("Potatoes", vegetables.get("Potatoes") + 1);
                break;
            case "L":
                vegetables.put("Lettuce", vegetables.get("Lettuce") + 1);
                break;
        }
        return vegetables;
    }

    private static boolean isOutOdBounds(int row, int col, String[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
