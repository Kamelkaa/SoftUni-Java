package Exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task_03_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> materials = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();

        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        while (true) {
            String[] quantityAndMaterials = input.toLowerCase().split(" ");

            for (int i = 0; i < quantityAndMaterials.length; i++) {
                if (i % 2 != 0) {
                    int quantity = Integer.parseInt(quantityAndMaterials[i - 1]);

                    switch (quantityAndMaterials[i]) {
                        case "shards":
                        case "fragments":
                        case "motes":
                            materials.put(quantityAndMaterials[i], materials.get(quantityAndMaterials[i]) + quantity);

                            if (materials.get(quantityAndMaterials[i]) >= 250) {
                                if (quantityAndMaterials[i].equals("fragments")) {
                                    System.out.println("Valanyr obtained!");
                                } else if (quantityAndMaterials[i].equals("shards")) {
                                    System.out.println("Shadowmourne obtained!");
                                } else {
                                    System.out.println("Dragonwrath obtained!");
                                }

                                materials.put(quantityAndMaterials[i], materials.get(quantityAndMaterials[i]) - 250);
                                materials.entrySet()
                                        .stream()
                                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                        .forEach(pair ->
                                                System.out.printf("%s: %d%n", pair.getKey(), pair.getValue()));

                                junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
                                return;
                            }
                            break;
                        default:
                            junk.putIfAbsent(quantityAndMaterials[i], 0);
                            junk.put(quantityAndMaterials[i], junk.get(quantityAndMaterials[i]) + quantity);
                            break;
                    }
                }
            }

            input = scanner.nextLine();
        }
    }
}
