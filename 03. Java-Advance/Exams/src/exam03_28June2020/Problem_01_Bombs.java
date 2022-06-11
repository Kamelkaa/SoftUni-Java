package exam03_28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class Problem_01_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effectsQueue = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casingsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(casingsStack::push);

        Map<Integer, String> bombTypes = new HashMap<>();
        bombTypes.put(40, "Datura Bombs");
        bombTypes.put(60, "Cherry Bombs");
        bombTypes.put(120, "Smoke Decoy Bombs");

        Map<String, Integer> madeBombs = new TreeMap<>();
        bombTypes.values()
                .forEach(b -> madeBombs.put(b, 0));

        boolean isPunchFilled = false;
        while (!effectsQueue.isEmpty() && !casingsStack.isEmpty()) {
            int effect = effectsQueue.poll();
            int casing = casingsStack.pop();
            int sum = effect + casing;

            if (sum == 40 || sum == 60 || sum == 120) {
                String typeOfBomb = bombTypes.get(sum);
                madeBombs.put(typeOfBomb, madeBombs.get(typeOfBomb) + 1);
            } else {
                while (sum != 40 && sum != 60 && sum != 120) {
                    casing -= 5;
                    sum = effect + casing;
                }
                String typeOfBomb = bombTypes.get(sum);
                madeBombs.put(typeOfBomb, madeBombs.get(typeOfBomb) + 1);
            }

            if (madeBombs.get("Cherry Bombs") >= 3 && madeBombs.get("Datura Bombs") >= 3
                    && madeBombs.get("Smoke Decoy Bombs") >= 3) {
                isPunchFilled = true;
                break;

            }
        }

        String massage = isPunchFilled
                ? "Bene! You have successfully filled the bomb pouch!"
                : "You don't have enough materials to fill the bomb pouch.";
        System.out.println(massage);
        System.out.println("Bomb Effects: " + getElementsInfo(effectsQueue));
        System.out.println("Bomb Casings: " + getElementsInfo(casingsStack));
        madeBombs.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static String getElementsInfo(ArrayDeque<Integer> array) {
        return array.isEmpty()
                ? "empty"
                : array.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
