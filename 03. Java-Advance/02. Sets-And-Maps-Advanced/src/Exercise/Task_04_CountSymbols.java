package Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task_04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<Character, Integer> counter = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            counter.putIfAbsent(currentSymbol, 0);
            counter.put(currentSymbol, counter.get(currentSymbol) + 1);
        }

        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            System.out.println(entry.getKey()+": " + entry.getValue()+" time/s");
        }
    }
}
