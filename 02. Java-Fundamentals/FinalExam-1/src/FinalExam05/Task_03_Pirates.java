package FinalExam05;

import java.util.*;

public class Task_03_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String info = scanner.nextLine();
        Map<String, List<Integer>> cities = new LinkedHashMap<>();

        while (!info.equals("Sail")) {
            String[] cityInfo = info.split("\\|\\|");
            String cityName = cityInfo[0];
            int cityPopulation = Integer.parseInt(cityInfo[1]);
            int cityGold = Integer.parseInt(cityInfo[2]);

            if (!cities.containsKey(cityName)) {
                cities.put(cityName, Arrays.asList(cityPopulation, cityGold)); //0 -> population, 1 -> gold
            } else {
                int newPopulation = cities.get(cityName).get(0) + cityPopulation;
                int newGold = cities.get(cityName).get(1) + cityGold;
                cities.get(cityName).set(0, newPopulation);
                cities.get(cityName).set(1, newGold);
            }
            info = scanner.nextLine();
        }

        String eventsInfo = scanner.nextLine();

        while (!eventsInfo.equals("End")) {
            String[] events = eventsInfo.split("=>");
            String eventType = events[0];
            String nameCity = events[1];

            switch (eventType) {
                case "Plunder":
                    int peopleForKill = Integer.parseInt(events[2]);
                    int goldForSteal = Integer.parseInt(events[3]);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", nameCity, goldForSteal, peopleForKill);

                    int peopleLeft = cities.get(nameCity).get(0) - peopleForKill;
                    int goldLEft = cities.get(nameCity).get(1) - goldForSteal;
                    cities.get(nameCity).set(0, peopleLeft);
                    cities.get(nameCity).set(1, goldLEft);

                    if (peopleLeft <= 0 || goldLEft <= 0) {
                        cities.remove(nameCity);
                        System.out.printf("%s has been wiped off the map!%n", nameCity);
                    }
                    break;
                case "Prosper":
                    int goldToIncreasing = Integer.parseInt(events[2]);

                    if (goldToIncreasing < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int newGold = cities.get(nameCity).get(1) + goldToIncreasing;
                        cities.get(nameCity).set(1, newGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldToIncreasing, nameCity, newGold);
                    }
                    break;
            }
            eventsInfo = scanner.nextLine();
        }

        if (!cities.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());

            cities.entrySet().stream().sorted((e1, e2) -> {
                int result = e2.getValue().get(1).compareTo(e1.getValue().get(1));
                if (result == 0) {
                    result = e1.getKey().compareTo(e2.getKey());
                }
                return result;
            }).forEach(entry -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                    entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));

        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
