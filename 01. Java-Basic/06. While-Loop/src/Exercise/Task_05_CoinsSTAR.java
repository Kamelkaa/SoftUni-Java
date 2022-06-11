package Exercise;

import java.util.Scanner;

public class Task_05_CoinsSTAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double coins = Double.parseDouble(scanner.nextLine());

        double lv = Math.floor(coins);
        double st = Math.round((coins - lv) * 100);
        int counterCoins = 0;

        while (lv > 0) {
            if (lv >= 2) {
                counterCoins++;
                lv = lv - 2;

            } else if (lv >= 1) {
                counterCoins++;
                lv = lv - 1;

            }
        }

        while (st > 0) {
            if (st >= 50) {
                counterCoins++;
                st = st - 50;

            } else if (st >= 20) {
                counterCoins++;
                st = st - 20;

            } else if (st >= 10) {
                counterCoins++;
                st = st - 10;

            } else if (st >= 5) {
                counterCoins++;
                st = st - 5;

            } else if (st >= 2) {
                counterCoins++;
                st = st - 2;

            } else if (st >= 1) {
                counterCoins++;
                st = st - 1;

            } else {
                break;
            }
        }

        System.out.println(counterCoins);
    }
}

