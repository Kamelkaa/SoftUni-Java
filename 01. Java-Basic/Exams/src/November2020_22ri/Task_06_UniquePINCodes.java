package November2020_22ri;

import java.util.Scanner;

public class Task_06_UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int upperLimitN1 = Integer.parseInt(scanner.nextLine());
        int upperLimitN2 = Integer.parseInt(scanner.nextLine());
        int upperLimitN3 = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= upperLimitN1; i++) {
            for (int j = 1; j <= upperLimitN2; j++) {
                for (int k = 1; k <= upperLimitN3; k++) {
                    int counterDel = 0;

                    for (int l = 1; l <= j; l++) {
                        if (j % l == 0) {
                            counterDel++;
                        }
                    }

                    if (i % 2 == 0 && k % 2 == 0 && counterDel == 2) {
                        System.out.printf("%d %d %d%n", i, j, k);
                    }
                }
            }
        }
    }
}
