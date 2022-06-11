package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_06_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!(first.isEmpty() || second.isEmpty())) {
            if (first.get(0).equals(second.get(0))) {
                first.remove(0);
                second.remove(0);
            } else if (first.get(0) > second.get(0)) {
                first.add(first.get(0));
                first.remove(0);
                first.add(second.get(0));
                second.remove(0);
            } else {
                second.add(second.get(0));
                second.remove(0);
                second.add(first.get(0));
                first.remove(0);
            }
        }

        if (first.isEmpty()) {
            int sum = second.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("Second player wins! Sum: %d", sum);
        } else {
            int sum = first.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("First player wins! Sum: %d", sum);
        }
    }
}

