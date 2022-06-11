package Lap;

import java.util.Scanner;

public class Task_11_MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int multiplayer = Integer.parseInt(scanner.nextLine());

        do {
            System.out.printf("%d X %d = %d%n", n, multiplayer, n * multiplayer);
            multiplayer++;
        } while (multiplayer <= 10);
    }
}
