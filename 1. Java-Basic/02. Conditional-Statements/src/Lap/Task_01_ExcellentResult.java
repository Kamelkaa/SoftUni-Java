package Lap;

import java.util.Scanner;

public class Task_01_ExcellentResult {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int evaluation = Integer.parseInt(scanner.nextLine());

        if (evaluation >= 5) {
            System.out.println("Excellent!");
        }
    }
}
