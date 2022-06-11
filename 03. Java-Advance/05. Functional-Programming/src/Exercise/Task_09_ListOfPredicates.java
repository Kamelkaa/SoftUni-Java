package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Task_09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int[] dividers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> numbersInRange = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            numbersInRange.add(i);
        }

        Predicate<Integer> divisibleChek = n -> {
            for (int divider : dividers) {
                if (n % divider != 0) {
                    return false;
                }
            }
            return true;
        };

        numbersInRange.forEach(e -> {
            if (divisibleChek.test(e)) {
                System.out.print(e + " ");
            }
        });
    }
}
