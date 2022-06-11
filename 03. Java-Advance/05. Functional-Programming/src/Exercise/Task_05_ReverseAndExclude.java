package Exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task_05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int divisionNumber = Integer.parseInt(scanner.nextLine());

        Collections.reverse(listOfNumbers);
        Predicate<Integer> divisionCheck = number ->
                number % divisionNumber == 0;
        listOfNumbers.removeIf(divisionCheck);

        Consumer<List<Integer>> print = list ->
                list.forEach(e -> System.out.print(e + " "));
        print.accept(listOfNumbers);
    }
}
