package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_04_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "Add":
                    int number = Integer.parseInt(input.split(" ")[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(input.split(" ")[1]);
                    int index = Integer.parseInt(input.split(" ")[2]);

                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, number);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(input.split(" ")[1]);

                    if (index >= 0 && index < numbers.size()) {
                        numbers.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = input.split(" ")[1];
                    int count = Integer.parseInt(input.split(" ")[2]);

                    if (direction.equals("left")) {
                        for (int i = 1; i <= count; i++) {
                            int firstNumber = numbers.get(0);
                            numbers.add(firstNumber);
                            numbers.remove(0);
                        }
                    } else if (direction.equals("right")) {
                        for (int i = 1; i <= count; i++) {
                            int lastNumber = numbers.get(numbers.size() - 1);
                            numbers.add(0, lastNumber);
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
