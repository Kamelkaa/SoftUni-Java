package Exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task_03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList);
//
//        Function<List<Integer>, Integer> findMin = array ->
//                array.stream()
//                        .mapToInt(Integer::intValue)
//                        .min()
//                        .orElse(0);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], Integer> findMin = array ->
                Arrays.stream(array).min().orElse(0);

        System.out.println(findMin.apply(numbers));
    }
}
