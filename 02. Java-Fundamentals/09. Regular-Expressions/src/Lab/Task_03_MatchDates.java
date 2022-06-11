package Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_03_MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputYears = scanner.nextLine();
        String regex = "\\b(?<day>\\d{2})([\\.\\/-])(?<month>[A-Z][a-z]{2})\\2(?<year>[1-2][0-9]{3})\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputYears);

        while (matcher.find()) {
            String day = matcher.group("day");
            String month = matcher.group("month");
            String year = matcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }
    }
}
