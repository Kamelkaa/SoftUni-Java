package FinalExam02;

import java.util.*;

public class Task_03_PlantDiscovery100to100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfPlants = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantsAndRarity = new HashMap<>();
        Map<String, List<Double>> plantsAndRating = new HashMap<>();

        for (int i = 0; i < numbersOfPlants; i++) {
            String[] plantsRarityInfo = scanner.nextLine().split("<->");
            String namePlant = plantsRarityInfo[0];
            int rarity = Integer.parseInt(plantsRarityInfo[1]);

            plantsAndRarity.put(namePlant, rarity);
            plantsAndRating.put(namePlant, new ArrayList<>());
        }

        String commandsInput = scanner.nextLine();

        while (!commandsInput.equals("Exhibition")) {
            String[] commandsType = commandsInput.split(" ");
            String command = commandsType[0];
            String plantName = commandsType[1];


            switch (command) {
                case "Rate:":
                    double rating = Double.parseDouble(commandsType[3]);
                    List<Double> ratings = plantsAndRating.get(plantName);
                    if (ratings != null) {
                        ratings.add(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update:":
                    int newRarity = Integer.parseInt(commandsType[3]);
                    if (plantsAndRarity.containsKey(plantName)) {
                        plantsAndRarity.put(plantName, newRarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset:":
                    List<Double> resetRating = plantsAndRating.get(plantName);
                    if (resetRating != null) {
                        resetRating.clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }

            commandsInput = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");

        Map<String, Double> plantsAndAverage = new HashMap<>();

        for (String s : plantsAndRating.keySet()) {
            double av = plantsAndRating.get(s).stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            plantsAndAverage.put(s, av);
        }

        plantsAndRarity.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparingDouble(e -> plantsAndAverage.get(e.getKey()))
                        .reversed())
                .forEach(k -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                        k.getKey(), k.getValue(), plantsAndAverage.get(k.getKey())));
    }
}