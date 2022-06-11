package Lab;

import java.util.*;

public class Task_03_OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        Map<String, Integer> counter = new LinkedHashMap<>();

        for (String word : words) {
            String wordToLowerCase = word.toLowerCase();
            if (counter.containsKey(wordToLowerCase)) {
                counter.put(wordToLowerCase, counter.get(wordToLowerCase) + 1);
            } else {
                counter.put(wordToLowerCase, 1);
            }
        }

        List<String> odds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }

        System.out.print(String.join(", ", odds));

    }
}
