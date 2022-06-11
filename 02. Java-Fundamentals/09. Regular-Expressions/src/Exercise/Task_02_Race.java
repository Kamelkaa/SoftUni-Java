package Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task_02_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racersNames = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        Map<String, Integer> racersAndDistance = new LinkedHashMap<>();
        racersNames.forEach(racer -> racersAndDistance.put(racer, 0));

        String name = "[A-Za-z]+";
        String distance = "[0-9]";
        Pattern patternName = Pattern.compile(name);
        Pattern patternDistance = Pattern.compile(distance);

        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            Matcher matcherName = patternName.matcher(input);
            Matcher matcherDistance = patternDistance.matcher(input);

            StringBuilder buildingName = new StringBuilder();
            while (matcherName.find()) {
                buildingName.append(matcherName.group());
            }
            String builtName = buildingName.toString();

            int sumDistance = 0;
            while (matcherDistance.find()) {
                sumDistance += Integer.parseInt(matcherDistance.group());
            }

            if (racersAndDistance.containsKey(builtName)) {
                racersAndDistance.put(builtName, racersAndDistance.get(builtName) + sumDistance);
            }

            input = scanner.nextLine();
        }

        List<String> firstThreePlaces = racersAndDistance.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.printf("1st place: %s%n" +
                        "2nd place: %s%n" +
                        "3rd place: %s",
                firstThreePlaces.get(0), firstThreePlaces.get(1), firstThreePlaces.get(2));
    }
}
