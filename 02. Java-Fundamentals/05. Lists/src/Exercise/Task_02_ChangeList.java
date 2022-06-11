package Exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String command = input.split(" ")[0];
            int element = Integer.parseInt(input.split(" ")[1]);

            switch (command) {
                case "Delete":
                    numbers.removeAll(Arrays.asList(element));
                    break;
                case "Insert":
                    element = Integer.parseInt(input.split(" ")[1]);
                    int index = Integer.parseInt(input.split(" ")[2]);
                    numbers.add(index, element);
                    break;
            }

            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
