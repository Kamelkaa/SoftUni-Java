package exam01_16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class Problem_01_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<String, Integer> madeFood = new TreeMap<>();
        madeFood.put("Bread", 0);
        madeFood.put("Cake", 0);
        madeFood.put("Pastry", 0);
        madeFood.put("Fruit Pie", 0);

        while (liquidsQueue.size() != 0 && ingredientsStack.size() != 0) {
            chekValuesIsEqual(liquidsQueue, ingredientsStack, madeFood);
        }

        if (isAllTypeFoodIsMadeIs(madeFood)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            printArray(liquidsQueue);
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            printArray(ingredientsStack);
        }

        madeFood.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static void printArray(ArrayDeque<Integer> array) {
        List<String> collect = array.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.print(String.join(", ", collect));
        System.out.println();

    }

    private static boolean isAllTypeFoodIsMadeIs(Map<String, Integer> madeFood) {
        for (int value : madeFood.values()) {
            if (value == 0) {
                return false;
            }
        }
        return true;
    }

    private static void chekValuesIsEqual(ArrayDeque<Integer> liquidsQueue, ArrayDeque<Integer> ingredientsStack,
                                          Map<String, Integer> madeFood) {
        int sum = liquidsQueue.peek() + ingredientsStack.peek();
        String nameFood;

        if (sum == 25) {
            nameFood = "Bread";
            cookTheFood(liquidsQueue, ingredientsStack, madeFood, nameFood);
        } else if (sum == 50) {
            nameFood = "Cake";
            cookTheFood(liquidsQueue, ingredientsStack, madeFood, nameFood);
        } else if (sum == 75) {
            nameFood = "Pastry";
            cookTheFood(liquidsQueue, ingredientsStack, madeFood, nameFood);
        } else if (sum == 100) {
            nameFood = "Fruit Pie";
            cookTheFood(liquidsQueue, ingredientsStack, madeFood, nameFood);
        } else {
            liquidsQueue.poll();
            int current = ingredientsStack.pop() + 3;
            ingredientsStack.push(current);
        }
    }

    private static void cookTheFood(ArrayDeque<Integer> liquidsQueue, ArrayDeque<Integer> ingredientsStack,
                                    Map<String, Integer> madeFood, String nameFood) {
        madeFood.put(nameFood, madeFood.get(nameFood) + 1);
        liquidsQueue.poll();
        ingredientsStack.pop();
    }
}
