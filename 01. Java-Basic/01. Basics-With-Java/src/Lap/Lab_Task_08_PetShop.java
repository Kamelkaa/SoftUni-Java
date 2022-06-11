package Lap;

import java.util.Scanner;

public class Lab_Task_08_PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDogs = Integer.parseInt(scanner.nextLine());
        int numberOfOtherPets = Integer.parseInt(scanner.nextLine());
        double sum = numberOfDogs * 2.50 + numberOfOtherPets * 4;

        System.out.printf("%.1f lv.", sum);
    }
}
