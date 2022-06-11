package exam07_20February2021;

import java.util.*;
import java.util.stream.Collectors;

public class Problem_01_MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstMagicBox = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondMagicBox::push);

        List<Integer> claimedItems = new ArrayList<>();

        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {
            int firstElement = firstMagicBox.peek();
            int secondElement = secondMagicBox.pop();
            int sum = firstElement + secondElement;

            if (isEvenSum(sum)) {
                claimedItems.add(sum);
                firstMagicBox.poll();
            } else {
                firstMagicBox.offer(secondElement);
            }
        }

        if (firstMagicBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondMagicBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        int sumOfAllClaimedItems = claimedItems.stream().mapToInt(Integer::intValue).sum();
        if (sumOfAllClaimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", sumOfAllClaimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d", sumOfAllClaimedItems);
        }
    }

    private static boolean isEvenSum(int sum) {
        return sum % 2 == 0;
    }
}
