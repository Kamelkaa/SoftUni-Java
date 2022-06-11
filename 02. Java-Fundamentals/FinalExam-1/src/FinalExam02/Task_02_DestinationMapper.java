package FinalExam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_02_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regexPlaces = "(?<separator>[=/])(?<thePlace>[A-Z][A-Za-z]{2,})\\1";

        Pattern patternPlaces = Pattern.compile(regexPlaces);
        Matcher matcherPlaces = patternPlaces.matcher(text);
        List<String> places = new ArrayList<>();
        int travelPoints = 0;

        while (matcherPlaces.find()) {
            String thePlace = matcherPlaces.group("thePlace");
            places.add(thePlace);
            travelPoints += thePlace.length();
        }

        System.out.printf("Destinations: %s%n", String.join(", ", places));
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
