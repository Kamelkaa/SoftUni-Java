package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_02_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> resourcesAndQuantity = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourcesAndQuantity.containsKey(input)) {
                resourcesAndQuantity.put(input, quantity);
            } else {
                resourcesAndQuantity.put(input, resourcesAndQuantity.get(input) + quantity);
            }

            input = scanner.nextLine();
        }

        resourcesAndQuantity.forEach((k, v) -> System.out.printf("%s -> %d%n", k, v));
    }
}
