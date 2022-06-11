package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_01_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Map<Character, Integer> countLetters = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (currentSymbol == ' ') {
                continue;
            }

            if (!countLetters.containsKey(currentSymbol)) {
                countLetters.put(currentSymbol, 1);
            } else {
                countLetters.put(currentSymbol, countLetters.get(currentSymbol) + 1);
            }
        }

        countLetters.forEach((k, v) -> System.out.printf("%c -> %d%n", k, v));
        //   for (Map.Entry<Character, Integer> entry : countLetters.entrySet()) {
        //      System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        //  }
    }
}
