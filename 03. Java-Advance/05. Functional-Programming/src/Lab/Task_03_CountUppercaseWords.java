package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Task_03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isStartWithUpperLetter = word ->
                Character.isUpperCase(word.charAt(0));

        String[] wordsStartWhitUpperCase = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(isStartWithUpperLetter)
                .toArray(String[]::new);

        System.out.println(wordsStartWhitUpperCase.length);
        Arrays.stream(wordsStartWhitUpperCase)
                .forEach(System.out::println);
    }
}
