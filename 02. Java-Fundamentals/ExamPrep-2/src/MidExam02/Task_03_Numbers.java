package MidExam02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_03_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        double average = 1.0 * sum / numbers.size();


        List<String> sortedNumbers = numbers.stream()
                .filter(n -> n > average)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .limit(5)
                .map(String::valueOf)
                .collect(Collectors.toList());


        if (sortedNumbers.size() == 0) {
            System.out.println("No");
        } else {
            System.out.println(String.join(" ", sortedNumbers));
        }
    }
}
