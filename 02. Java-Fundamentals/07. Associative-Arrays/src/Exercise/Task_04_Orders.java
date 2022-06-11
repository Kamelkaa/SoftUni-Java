package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_04_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> productsAndQuantity = new LinkedHashMap<>();
        Map<String, Double> productsAndPrice = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String name = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);

            productsAndPrice.put(name, price);

            if (!productsAndQuantity.containsKey(name)) {
                productsAndQuantity.put(name, quantity);
            } else {
                productsAndQuantity.put(name, productsAndQuantity.get(name) + quantity);
            }

            input = scanner.nextLine();
        }

        productsAndPrice.forEach((key, value) ->
                System.out.printf("%s -> %.2f%n", key, value * productsAndQuantity.get(key)));

    }
}
