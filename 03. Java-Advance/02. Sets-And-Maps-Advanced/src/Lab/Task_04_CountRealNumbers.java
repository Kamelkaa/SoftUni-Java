package Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task_04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        LinkedHashMap<Double, Integer> countOccurrence = new LinkedHashMap<>();

        for (double number : numbers) {

            if (!countOccurrence.containsKey(number)) {
                countOccurrence.put(number, 1);
            } else {
                countOccurrence.put(number, countOccurrence.get(number) + 1);
            }
        }

        countOccurrence.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
