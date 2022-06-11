package Lab;

import java.util.*;

public class Task_07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfContinents = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continentInfo = new LinkedHashMap<>();

        while (numbersOfContinents-- > 0) {
            String[] info = scanner.nextLine().split("\\s+");
            String continent = info[0];
            String country = info[1];
            String city = info[2];

            continentInfo.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>> countryInfo = continentInfo.get(continent);
            countryInfo.putIfAbsent(country, new ArrayList<>());
            countryInfo.get(country).add(city);
        }

        continentInfo.forEach((continent, countryInfo) -> {
            System.out.printf("%s:%n", continent);

            for (Map.Entry<String, List<String>> entryCountry : countryInfo.entrySet()) {
                System.out.printf("  %s -> %s%n", entryCountry.getKey(), String.join(", ", entryCountry.getValue()));
            }
        });
//        continentInfo.forEach((k, v) -> {
//            System.out.printf("%s:%n", k);
//            v.forEach((k1, v1) ->
//                    System.out.printf("  %s -> %s%n", k1, String.join(", ", v1)));
//        });
//    }
    }
}
