package FinalExam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_02_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textString = scanner.nextLine();
        String regexFood = "([#\\|])(?<name>[A-Za-z]+ ?[A-Za-z]*)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>\\d+)\\1";
        Pattern patternFood = Pattern.compile(regexFood);
        Matcher matcherFood = patternFood.matcher(textString);

        List<String> foodInfo = new ArrayList<>();
        int sumCalories = 0;

        while (matcherFood.find()) {
            foodInfo.add(String.format("Item: %s, Best before: %s, Nutrition: %s",
                    matcherFood.group("name"), matcherFood.group("date"), matcherFood.group("calories")));
            int calories = Integer.parseInt(matcherFood.group("calories"));
            sumCalories += calories;
        }

        int days = sumCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        foodInfo.forEach(System.out::println);
    }
}
