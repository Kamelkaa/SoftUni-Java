package FinalExam05;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_02_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();

        String regexCoolThreshold = "\\d";
        Pattern patternCool = Pattern.compile(regexCoolThreshold);
        Matcher matcherCool = patternCool.matcher(inputText);

        long coolThreshold = 1L;
        while (matcherCool.find()) {
            int number = Integer.parseInt(matcherCool.group());
            coolThreshold *= number;
        }

        String regexEmoji = "([:*])\\1(?<emoji>[A-Z][a-z]{2,})\\1\\1";
        Pattern patternEmoji = Pattern.compile(regexEmoji);
        Matcher matcherEmoji = patternEmoji.matcher(inputText);

        Map<String, Long> emojis = new LinkedHashMap<>();

        while (matcherEmoji.find()) {
            String emoji = matcherEmoji.group("emoji");
            String fullEmoji = matcherEmoji.group();
            long coolCurrentEmoji = getCoolThreshold(emoji);

            emojis.put(fullEmoji, coolCurrentEmoji);
        }

        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojis.size());

        long finalCoolThreshold = coolThreshold;
        emojis.entrySet().stream().filter(e -> e.getValue() >= finalCoolThreshold)
                .forEach(entry -> System.out.println(entry.getKey()));

    }

    private static long getCoolThreshold(String emoji) {
        long cool = 0;
        for (int i = 0; i < emoji.length(); i++) {
            char currentSymbol = emoji.charAt(i);
            cool += currentSymbol;
        }
        return cool;
    }
}
