package November2020_22ri;

import java.util.Scanner;

public class Task_01_CatDiet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int percentFat = Integer.parseInt(scanner.nextLine());
        int percentProteins = Integer.parseInt(scanner.nextLine());
        int percentCarbohydrates = Integer.parseInt(scanner.nextLine());
        int totalCalories = Integer.parseInt(scanner.nextLine());
        int percentWater = Integer.parseInt(scanner.nextLine());

        double totalGramsFat = (percentFat * 0.01 * totalCalories) / 9;
        double totalGramsProteins = (percentProteins * 0.01 * totalCalories) / 4;
        double totalGramsCarbohydrates = (percentCarbohydrates * 0.01 * totalCalories) / 4;
        double totalGrams = totalGramsFat + totalGramsProteins + totalGramsCarbohydrates;
        double oneGramCalories = totalCalories / totalGrams;
        double caloriesWithoutWater = (100 - percentWater) * 0.01 * oneGramCalories;


        System.out.printf("%.4f", caloriesWithoutWater);
    }
}
