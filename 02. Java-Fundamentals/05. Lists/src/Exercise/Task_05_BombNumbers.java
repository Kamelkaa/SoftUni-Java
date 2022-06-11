package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_05_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequenceOfNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        String[] numberAndPower = scanner.nextLine().split(" ");
        int specialNumber = Integer.parseInt(numberAndPower[0]);
        int power = Integer.parseInt(numberAndPower[1]);

        while (sequenceOfNumbers.contains(specialNumber)) {
            int indexPower = sequenceOfNumbers.indexOf(specialNumber);

            int maxLeft = Math.max(0, indexPower - power);
            int maxRight = Math.min(sequenceOfNumbers.size() - 1, indexPower + power);

            for (int i = maxRight; i >= maxLeft; i--) {
                sequenceOfNumbers.remove(i);
            }
        }

        int sum = sequenceOfNumbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}