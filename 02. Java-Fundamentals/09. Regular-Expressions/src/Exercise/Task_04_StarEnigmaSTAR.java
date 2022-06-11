package Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_04_StarEnigmaSTAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < numberOfMessages; i++) {
            String encryptedMessage = scanner.nextLine();

            String regexSpecialLetters = "[SsTtAaRr]";
            Pattern patternSpecialLetters = Pattern.compile(regexSpecialLetters);
            Matcher matcherSpecialLetters = patternSpecialLetters.matcher(encryptedMessage);

            int countSpecialLetters = 0;
            while (matcherSpecialLetters.find()) {
                countSpecialLetters++;
            }

            StringBuilder newMessage = new StringBuilder();
            for (int j = 0; j < encryptedMessage.length(); j++) {
                char currentSymbol = encryptedMessage.charAt(j);
                newMessage.append((char) (currentSymbol - countSpecialLetters));
            }

            String decryptedMessage = newMessage.toString();

            String regexMessage = "@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<population>[0-9]+)[^@\\-!:>]*!(?<attack>[AD])![^@\\-!:>]*->(?<soldierCount>[0-9]+)";
            Pattern patternMessage = Pattern.compile(regexMessage);
            Matcher matcherMessage = patternMessage.matcher(decryptedMessage);
            while (matcherMessage.find()) {
                String planetName = matcherMessage.group("planetName");
                String typeOfAttack = matcherMessage.group("attack");

                if (typeOfAttack.equals("A")) {
                    attackedPlanets.add(planetName);
                } else if (typeOfAttack.equals("D")) {
                    destroyedPlanets.add(planetName);
                }
            }
        }

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        if (!attackedPlanets.isEmpty()) {
            attackedPlanets.stream().sorted().forEach(e -> System.out.println("-> " + e));
        }
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        if (!destroyedPlanets.isEmpty()) {
            destroyedPlanets.stream().sorted().forEach(e -> System.out.println("-> " + e));
        }
    }
}
