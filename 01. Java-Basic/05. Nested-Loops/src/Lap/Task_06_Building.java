package Lap;

import java.util.Scanner;

public class Task_06_Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberFloor = Integer.parseInt(scanner.nextLine());
        int numberRooms = Integer.parseInt(scanner.nextLine());

        for (int i = numberFloor; i >= 1; i--) {
            for (int j = 0; j < numberRooms; j++) {

                if (i == numberFloor) {
                    System.out.printf("L%d%d ", i, j);
                } else if (i % 2 == 0) {
                    System.out.printf("O%d%d ", i, j);
                } else {
                    System.out.printf("A%d%d ", i, j);
                }
            }

            System.out.println();
        }
    }
}
