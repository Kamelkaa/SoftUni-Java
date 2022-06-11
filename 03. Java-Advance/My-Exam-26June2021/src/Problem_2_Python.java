import java.util.Scanner;

public class Problem_2_Python {
    static int startRow;
    static int startCol;
    static int pythonLength = 1;
    static int numberOfAllFood = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] inputCommands = scanner.nextLine().split(", ");
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("f")) {
                    numberOfAllFood++;
                }
                if (matrix[row][col].equals("s")) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        boolean isNotTheEnd = true;
        for (int i = 0; i < inputCommands.length; i++) {
            String currentCommand = inputCommands[i];

            while (numberOfAllFood > 0 && isNotTheEnd) {
                if ("up".equals(currentCommand)) {
                    isNotTheEnd = move(startRow - 1, startCol, matrix, currentCommand);
                    break;
                } else if ("down".equals(currentCommand)) {
                    isNotTheEnd = move(startRow + 1, startCol, matrix, currentCommand);
                    break;
                } else if ("left".equals(currentCommand)) {
                    isNotTheEnd = move(startRow, startCol - 1, matrix, currentCommand);
                    break;
                } else if ("right".equals(currentCommand)) {
                    isNotTheEnd = move(startRow, startCol + 1, matrix, currentCommand);
                    break;
                }
            }

            if (numberOfAllFood == 0) {
                System.out.printf("You win! Final python length is %d", pythonLength);
                break;
            }
        }

        if (numberOfAllFood > 0 && isNotTheEnd) {
            System.out.printf("You lose! There is still %d food to be eaten.", numberOfAllFood);
        }
    }

    private static boolean move(int newRow, int newCol, String[][] matrix, String command) {
        matrix[startRow][startCol] = "*";

        if (isOutOdBounds(newRow, newCol, matrix)) {
            int[] newPosition = findPositionOnOtherSide(command, matrix);
            if (matrix[newPosition[0]][newPosition[1]].equals("e")) {
                matrix[newPosition[0]][newPosition[1]] = "s";
                System.out.println("You lose! Killed by an enemy!");
                return false;
            }else if(matrix[newPosition[0]][newPosition[1]].equals("f")){
                numberOfAllFood--;
                pythonLength++;
            }

            matrix[newPosition[0]][newPosition[1]] = "s";
            startRow = newPosition[0];
            startCol = newPosition[1];
            return true;
        }

        String currentSymbol = matrix[newRow][newCol];
        if (currentSymbol.equals("f")) {
            numberOfAllFood--;
            pythonLength++;
        } else if (currentSymbol.equals("e")) {
            matrix[newRow][newCol] = "s";
            System.out.println("You lose! Killed by an enemy!");
            return false;
        }

        matrix[newRow][newCol] = "s";
        startRow = newRow;
        startCol = newCol;
        return true;
    }

    private static int[] findPositionOnOtherSide(String command, String[][] matrix) {
        int[] indexes = new int[2];
        if ("up".equals(command)) {
            indexes = new int[]{matrix.length - 1, startCol};
        } else if ("down".equals(command)) {
            indexes = new int[]{0, startCol};
        } else if ("left".equals(command)) {
            indexes = new int[]{startRow, matrix.length - 1};
        } else if ("right".equals(command)) {
            indexes = new int[]{startRow, 0};
        }
        return indexes;
    }

    private static boolean isOutOdBounds(int row, int col, String[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }
}
