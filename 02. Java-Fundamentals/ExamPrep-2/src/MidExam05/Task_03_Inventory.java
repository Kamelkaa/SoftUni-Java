package MidExam05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(", ");
        List<String> collectedItems = Arrays.stream(items).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {
            String currentCommand = command.split(" - ")[0];
            String craftedItem = command.split(" - ")[1];

            switch (currentCommand) {
                case "Collect":
                    if (!collectedItems.contains(craftedItem)) {
                        collectedItems.add(craftedItem);
                    } else {
                        break;
                    }
                    break;

                case "Drop":
                    if (collectedItems.contains(craftedItem)) {
                        collectedItems.remove(craftedItem);
                    } else {
                        break;
                    }
                    break;

                case "Combine Items":
                    String oldItem = craftedItem.split(":")[0];
                    String newItem = craftedItem.split(":")[1];
                    int index = collectedItems.indexOf(oldItem) + 1;

                    if (collectedItems.contains(oldItem)) {
                        collectedItems.add(index, newItem);
                    } else {
                        break;
                    }
                    break;

                case "Renew":
                    if (collectedItems.contains(craftedItem)) {
                        collectedItems.remove(craftedItem);
                        collectedItems.add(craftedItem);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", collectedItems));
    }
}
