package exercise.foodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyers = new LinkedHashMap<>();

        while (n-- > 0) {
            Buyer buyer;
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length == 3) {
                buyer = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            } else {
                buyer = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            }
            buyers.put(tokens[0], buyer);
        }

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            Buyer buyer = buyers.get(line);
            if (buyer != null) {
                buyer.buyFood();
            }
            line = scanner.nextLine();
        }

        System.out.println(buyers.values().stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }
}

