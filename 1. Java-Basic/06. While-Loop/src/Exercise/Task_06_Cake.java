package Exercise;

import java.util.Scanner;

public class Task_06_Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        String text = scanner.nextLine();

        int numberOfPieces = a * b;
        int amountOfPieces = 0;

        while (!text.equals("STOP")) {
            int pieces = Integer.parseInt(text);

            amountOfPieces = amountOfPieces + pieces;

            if (amountOfPieces >= numberOfPieces) {
                int needed = amountOfPieces - numberOfPieces;
                System.out.printf("No more cake left! You need %d pieces more.", needed);
                break;
            }

            text = scanner.nextLine();
        }

        if (text.equals("STOP")) {
            int left = numberOfPieces - amountOfPieces;
            System.out.printf("%d pieces are left.", left);
        }
    }
}

