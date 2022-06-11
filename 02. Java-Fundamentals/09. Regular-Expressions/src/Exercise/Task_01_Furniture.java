package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_01_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        double totalMoney = 0;
        List<String> listWithFurniture = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String furnitureName = matcher.group("furnitureName");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                listWithFurniture.add(furnitureName);
                totalMoney += (price * quantity);
            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        listWithFurniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalMoney);
    }
}
