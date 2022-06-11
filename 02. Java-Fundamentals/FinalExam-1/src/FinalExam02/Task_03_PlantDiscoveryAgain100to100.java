package FinalExam02;

import java.util.*;

public class Task_03_PlantDiscoveryAgain100to100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantsAndRarity = new HashMap<>();
        Map<String, List<Integer>> plantsAndRating = new HashMap<>();

        for (int i = 0; i < number; i++) {
            String[] plantsInfo = scanner.nextLine().split("<->");
            String namePlants = plantsInfo[0];
            int rarity = Integer.parseInt(plantsInfo[1]);

            plantsAndRarity.put(namePlants, rarity);
            plantsAndRating.put(namePlants, new ArrayList<>());
        }

        String commandInput = scanner.nextLine();
        while (!commandInput.equals("Exhibition")) {
            String[] types = commandInput.split(": ");
            String commandName = types[0];
            String[] otherCommands = types[1].split(" - ");
            String namePlant = otherCommands[0];

            switch (commandName) {
                case "Rate":
                    int rating = Integer.parseInt(otherCommands[1]);
                    List<Integer> ratings = plantsAndRating.get(namePlant);
                    if (ratings != null) {
                        ratings.add(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(otherCommands[1]);
                    if (plantsAndRarity.containsKey(namePlant)) {
                        plantsAndRarity.put(namePlant, newRarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    List<Integer> resetRatings = plantsAndRating.get(namePlant);
                    if (resetRatings != null) {
                        resetRatings.clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }

            commandInput = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");

        plantsAndRarity.entrySet().stream().sorted((e1, e2) -> {
            int e1Rarity = e1.getValue();
            int e2Rarity = e2.getValue();
            if (e1Rarity != e2Rarity) {
                return Integer.compare(e2Rarity, e1Rarity);//rarity descending
            } else {
                List<Integer> e1RatingList = plantsAndRating.get(e1.getKey());
                List<Integer> e2RatingList = plantsAndRating.get(e2.getKey());

                double e1Average = calculateAverage(e1RatingList);
                double e2Average = calculateAverage(e2RatingList);

                return Double.compare(e2Average, e1Average);//rating descending
            }
        })
                .map(entry -> "- " + entry.getKey() + "; Rarity: " + entry.getValue() + "; Rating: " + String.format("%.2f", calculateAverage(plantsAndRating.get(entry.getKey()))))
                .forEach(System.out::println);
    }

  static double calculateAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum / numbers.size();
    }
}
