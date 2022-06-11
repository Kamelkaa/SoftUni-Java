package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task_07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestElement = list -> {
            int min = Integer.MAX_VALUE;
            for (int number : list) {
                if (number < min) {
                    min = number;
                }
            }
            return list.lastIndexOf(min);
        };
        Consumer<Integer> print = System.out::println;

        print.accept(findSmallestElement.apply(numbers));
    }
}
