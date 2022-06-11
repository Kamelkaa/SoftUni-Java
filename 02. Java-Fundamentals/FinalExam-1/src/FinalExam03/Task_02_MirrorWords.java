package FinalExam03;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_02_MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String regexWordPear = "(?<surrounder>[@#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        int countPears = 0;
        List<String> mirrorWords = new ArrayList<>();


        Pattern patternWord = Pattern.compile(regexWordPear);
        Matcher matcherWord = patternWord.matcher(text);

        while (matcherWord.find()) {
            countPears++;

            String firstWord = matcherWord.group("first");
            String secondWord = matcherWord.group("second");
            String reversedSecondWord = new StringBuilder(secondWord).reverse().toString();

            if (firstWord.equals(reversedSecondWord)) {
                mirrorWords.add(firstWord + " <=> " + secondWord);
            }
        }

        if (countPears == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", countPears);
        }

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.printf("The mirror words are:%n" +
                    "%s", String.join(", ", mirrorWords));
        }
    }
}
