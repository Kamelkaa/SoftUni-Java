package exam04_22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem_01_Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);

        int claimedItemsValue = 0;
        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstBoxItem = firstBoxQueue.peek();
            int secondBoxItem = secondBoxStack.peek();
            int sum = firstBoxItem + secondBoxItem;

            if (sum % 2 == 0) {
                firstBoxQueue.poll();
                secondBoxStack.pop();
                claimedItemsValue += sum;
            } else {
                firstBoxQueue.add(secondBoxStack.pop());
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if (claimedItemsValue >= 100) {
            System.out.printf("Your loot was epic! Value: %d", claimedItemsValue);
        } else {
            System.out.printf("Your loot was poor... Value: %d", claimedItemsValue);
        }
    }
}
