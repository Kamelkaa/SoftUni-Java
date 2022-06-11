package Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task_06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, Map<String, Double>> shopsAndProducts = new TreeMap<>();

        while (!input.equals("Revision")) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            shopsAndProducts.putIfAbsent(shop, new LinkedHashMap<>());
            shopsAndProducts.get(shop).putIfAbsent(product, price);

            input = scanner.nextLine();
        }

        shopsAndProducts.forEach((k, v) -> {
            System.out.printf("%s->%n", k);
            v.forEach((k1, v1) ->
                    System.out.printf("Product: %s, Price: %.1f%n", k1, v1));
        });
    }
}
