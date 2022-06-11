package Exercise;

import java.util.Scanner;

public class Task_07_StringExplosionV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int strengthBomb = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);

            if (currentSymbol != '>' && strengthBomb > 0) {
                text = text.substring(0, i) + text.substring(i + 1);
                strengthBomb--;
                i--;
            }

            if (currentSymbol == '>' && text.charAt(i + 1) != '>') {
                strengthBomb += Integer.parseInt(String.valueOf(text.charAt(i + 1)));
            }
        }

        System.out.println(text);
    }
}
