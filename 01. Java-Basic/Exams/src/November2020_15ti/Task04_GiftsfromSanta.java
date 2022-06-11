package November2020_15ti;

import java.util.Scanner;

public class Task04_GiftsfromSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int s = Integer.parseInt(scanner.nextLine());

        int current = 0;
        for (int i = m; i >= n; i--) {
            if (i % 2 == 0 && i % 3 == 0) {
                current = i;
                if (current == s) {
                    break;
                }
                System.out.printf("%d ", current);
            }
        }
    }
}
