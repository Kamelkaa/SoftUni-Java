package Lap;

import java.util.Scanner;

public class Task_07_ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstLine = scanner.nextLine().charAt(0);
        char secondLine = scanner.nextLine().charAt(0);
        char thirdLine = scanner.nextLine().charAt(0);

        //  String firstLine = scanner.nextLine();
        // String secondLine = scanner.nextLine();
        // String thirdLine = scanner.nextLine();

        System.out.println(thirdLine + " " + secondLine + " " + firstLine);
    }
}
