package MidExam01Retake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_03_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        int countMoves = 0;

        while (!input.equals("end")) {
            int firsIndex = Integer.parseInt(input.split(" ")[0]);
            int secondIndex = Integer.parseInt(input.split(" ")[1]);

            if (elements.isEmpty()) {
                System.out.printf("You have won in %d turns!", countMoves);
                return;
            } else {
                if (firsIndex == secondIndex || firsIndex < 0 || secondIndex < 0 || firsIndex >= elements.size() || secondIndex >= elements.size()) {
                    countMoves++;
                    elements.add(elements.size() / 2, "-" + countMoves + "a");
                    elements.add(elements.size() / 2 + 1, "-" + countMoves + "a");
                    System.out.println("Invalid input! Adding additional elements to the board");
                } else if (elements.get(firsIndex).equals(elements.get(secondIndex))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", elements.get(firsIndex));
                    String element = elements.get(firsIndex);
                    elements.remove(element);
                    elements.remove(element);
                    countMoves++;
                } else {
                    System.out.println("Try again!");
                    countMoves++;
                }
            }

            input = scanner.nextLine();
        }

        if (!elements.isEmpty()) {
            System.out.printf("Sorry you lose :(%n%s", String.join(" ", elements));

        }
    }
}
