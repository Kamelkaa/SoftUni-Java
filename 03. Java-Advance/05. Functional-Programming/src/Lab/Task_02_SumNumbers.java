package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task_02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> count = List::size;
        Function<List<Integer>, Integer> sum = list ->
                list.stream()
                        .mapToInt(Integer::intValue)
                        .sum();

        System.out.println("Count = " + count.apply(numberList));
        System.out.println("Sum = " + sum.apply(numberList));
    }
}
