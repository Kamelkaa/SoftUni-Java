package March2020;

import java.util.Scanner;

public class Task04_1_FoodForPets {
    public static void main(String[] args) {
        //⦁	"Total eaten biscuits: {количество изядени бисквитки}gr."
        //⦁	"{процент изядена храна}% of the food has been eaten."
        //⦁	"{процент изядена храна от кучето}% eaten from the dog."
        //⦁	"{процент изядена храна от котката}% eaten from the cat."
        Scanner scanner = new Scanner(System.in);

        int numbersOfDays = Integer.parseInt(scanner.nextLine());
        double totalAmountOfFood = Double.parseDouble(scanner.nextLine());

        int amountOfFoodDog = 0;
        int amountOfFoodCat = 0;

        for (int i = 0; i < numbersOfDays; i++) {
            amountOfFoodDog = Integer.parseInt(scanner.nextLine());
            amountOfFoodCat = Integer.parseInt(scanner.nextLine());
        }
    }
}
