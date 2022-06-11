package exam06_23Oct2019;

import java.util.*;
import java.util.stream.Collectors;

public class Problem_02_MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vegetablesQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> caloriesForSaladsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(caloriesForSaladsStack::push);

        while (!vegetablesQueue.isEmpty() && !caloriesForSaladsStack.isEmpty()) {
            int currentSalad = caloriesForSaladsStack.peek();
            while (currentSalad > 0 && !vegetablesQueue.isEmpty()) {
                int currentCalories = getCaloriesFromCurrentVegetable(vegetablesQueue.poll());
                currentSalad -= currentCalories;
            }
            System.out.print(caloriesForSaladsStack.pop() + " ");
        }

        System.out.println();
        if (!vegetablesQueue.isEmpty()) {
            vegetablesQueue.forEach(v -> System.out.print(v + " "));
        } else {
            caloriesForSaladsStack.forEach(c -> System.out.print(c + " "));
        }
    }

    private static int getCaloriesFromCurrentVegetable(String vegetable) {
        int calories = 0;
        switch (vegetable) {
            case "tomato":
                calories = 80;
                break;
            case "carrot":
                calories = 136;
                break;
            case "lettuce":
                calories = 109;
                break;
            case "potato":
                calories = 215;
                break;
        }
        return calories;
    }
}
