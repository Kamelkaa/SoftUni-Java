package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_05_NetherRealmsSTAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demonsInformation = scanner.nextLine().split("\\s*,\\s*");
        Map<String, Map<Integer, Double>> participants = new TreeMap<>();

        String regexHealth = "[^.+\\-*/[0-9]]";
        String regexDamage = "[+-]?[0-9]+\\.?[0-9]*";
        Pattern healthPattern = Pattern.compile(regexHealth);
        Pattern damagePattern = Pattern.compile(regexDamage);

        for (String demon : demonsInformation) {
            StringBuilder multiplicationOrDivision = new StringBuilder();

            for (int i = 0; i < demon.length(); i++) {
                char currentSymbol = demon.charAt(i);
                if (currentSymbol == '*') {
                    multiplicationOrDivision.append(currentSymbol);
                } else if (currentSymbol == '/') {
                    multiplicationOrDivision.append(currentSymbol);
                }
            }

            Matcher healthMatcher = healthPattern.matcher(demon);
            int health = 0;
            while (healthMatcher.find()) {
                char currentChar = healthMatcher.group().charAt(0);
                health += currentChar;
            }

            Matcher damageMatcher = damagePattern.matcher(demon);
            double damage = 0;
            while (damageMatcher.find()) {
                damage += Double.parseDouble(damageMatcher.group());
            }

            for (int i = 0; i < multiplicationOrDivision.length(); i++) {
                if (multiplicationOrDivision.charAt(i) == '*') {
                    damage *= 2;
                } else if (multiplicationOrDivision.charAt(i) == '/') {
                    damage /= 2;
                }
            }
            participants.putIfAbsent(demon, new LinkedHashMap<>());
            participants.get(demon).put(health, damage);
        }

        participants.forEach((key, value) -> value.forEach((health, damage) ->
                System.out.printf("%s - %d health, %.2f damage%n", key, health, damage)));
    }
}
