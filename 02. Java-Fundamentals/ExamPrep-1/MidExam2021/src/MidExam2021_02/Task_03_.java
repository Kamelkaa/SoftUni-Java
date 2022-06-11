package MidExam2021_02;

import java.util.*;
import java.util.stream.Collectors;

public class Task_03_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> deck = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
        List<String> newDeck = new ArrayList<>();

        String commands = scanner.nextLine();

        while (!commands.equals("Ready")) {
            String command = commands.split(" ")[0];
            String nameOfCard = commands.split(" ")[1];

            switch (command) {
                case "Add":
                    if (!deck.contains(nameOfCard)) {
                        System.out.println("Card not found.");
                    } else {
                        newDeck.add(nameOfCard);
                    }
                    break;

                case "Insert":
                    int index = Integer.parseInt(commands.split(" ")[2]);

                    if (!deck.contains(nameOfCard) || (index < 0 || index >= newDeck.size())) {
                        System.out.println("Error!");
                    } else {
                        newDeck.add(index, nameOfCard);
                    }
                    break;

                case "Remove":
                    if (!newDeck.contains(nameOfCard)) {
                        System.out.println("Card not found.");
                    } else {
                        newDeck.remove(nameOfCard);
                    }
                    break;

                case "Swap":
                    String nameFirstCard = commands.split(" ")[1];
                    int indexFirst = newDeck.indexOf(nameFirstCard);
                    String nameSecondCard = commands.split(" ")[2];
                    int indexSecond = newDeck.indexOf(nameSecondCard);
                    Collections.swap(newDeck, indexFirst, indexSecond);
                    break;

                case "Shuffle":
                    Collections.reverse(newDeck);
                    break;
            }

            commands = scanner.nextLine();
        }

        System.out.println(String.join(" ", newDeck));
    }
}
