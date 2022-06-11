package MidExam04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_02_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listForShopping = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String command = input.split(" ")[0];
            String item = input.split(" ")[1];

            switch (command) {
                case "Urgent":
                    if (!listForShopping.contains(item)) {
                        listForShopping.add(0, item);
                    } else {
                        break;
                    }
                    break;

                case "Unnecessary":
                    if (listForShopping.contains(item)) {
                        listForShopping.remove(item);
                    } else {
                        break;
                    }
                    break;

                case "Correct":
                    String newItem = input.split(" ")[2];
                    int index = listForShopping.indexOf(item);

                    if (listForShopping.contains(item)) {
                        listForShopping.set(index, newItem);
                    } else {
                        break;
                    }
                    break;

                case "Rearrange":
                    if (listForShopping.contains(item)) {
                        listForShopping.remove(item);
                        listForShopping.add(item);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", listForShopping));
    }
}
