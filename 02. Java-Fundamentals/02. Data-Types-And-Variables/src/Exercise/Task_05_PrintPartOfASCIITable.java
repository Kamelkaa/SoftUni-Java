package Exercise;

import java.util.Scanner;

public class Task_05_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startIndexChar = Integer.parseInt(scanner.nextLine());
        int endIndexChar = Integer.parseInt(scanner.nextLine());

        for (int i = startIndexChar; i <= endIndexChar; i++) {
            System.out.print((char) i + " ");
        }
    }
}
