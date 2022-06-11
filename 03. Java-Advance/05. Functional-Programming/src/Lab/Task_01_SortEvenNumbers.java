package Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task_01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Consumer<List<Integer>> printString = list -> {
            String listToString = list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(listToString);
        };

        numbers = numbers.stream()
                .filter(isEven)
                .collect(Collectors.toList());
        printString.accept(numbers);

        Collections.sort(numbers);
        printString.accept(numbers);
    }
}
