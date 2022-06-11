package exam01_16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class Problem_01_CookingV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<Integer, String> cookingTable = new HashMap<>();
        cookingTable.put(25, "Bread");
        cookingTable.put(50, "Cake");
        cookingTable.put(75, "Pastry");
        cookingTable.put(100, "Fruit Pie");

        Map<String, Integer> productsCooked = new TreeMap<>();
        cookingTable.values()
                .forEach(p -> productsCooked.put(p, 0));

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int sum = liquid + ingredient;

            if (ableToCookDish(sum)) {
                String product = cookingTable.get(sum);
                productsCooked.put(product, productsCooked.get(product) + 1);
            } else {
                ingredientsStack.push(ingredient + 3);
            }
        }

        if (hasCookedEachMeal(productsCooked)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        System.out.println("Liquids left: " + getElementsInfo(liquidsQueue));
        System.out.println("Ingredients left: " + getElementsInfo(ingredientsStack));
        productsCooked.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static String getElementsInfo(ArrayDeque<Integer> array) {
        return array.isEmpty()
                ? "none"
                : array.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private static boolean hasCookedEachMeal(Map<String, Integer> productsCooked) {
        for (int value : productsCooked.values()) {
            if (value == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean ableToCookDish(int sum) {
        return sum == 25 || sum == 50 || sum == 75 || sum == 100;
    }
}
