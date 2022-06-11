package Exercise;

import java.util.Scanner;

public class Task_10_RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double headset = 0;
        double mouse = 0;
        double keyboard = 0;
        double display = 0;

        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) {
                headset += headsetPrice;
            }
            if (i % 3 == 0) {
                mouse += mousePrice;
            }
            if (i % 6 == 0) {
                keyboard += keyboardPrice;
            }
            if (i % 12 == 0) {
                display += displayPrice;
            }
        }

        double totalPrice = headset + mouse + keyboard + display;
        System.out.printf("Rage expenses: %.2f lv.", totalPrice);
    }
}
