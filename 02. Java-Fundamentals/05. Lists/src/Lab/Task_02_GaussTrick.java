package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_02_GaussTrick {
    public static void main(String[] args) {
        //in judge - 80/100
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numbers.size() / 2; i++) {
            numbers.set(i, (numbers.get(i) + numbers.get(numbers.size() - 1)));
            numbers.remove(numbers.size() - 1);
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
