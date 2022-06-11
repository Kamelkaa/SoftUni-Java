package Exercise;

import java.util.Scanner;

public class Task_01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        int numberThree = Integer.parseInt(scanner.nextLine());

        printSmallestOfThreeNumbers(numberOne, numberTwo, numberThree);
    }

    private static void printSmallestOfThreeNumbers(int numberOne, int numberTwo, int numberThree) {
        if(numberOne<numberTwo){
            if(numberThree<numberOne){
                System.out.println(numberThree);
            }else {
                System.out.println(numberOne);
            }
        }else {
            if(numberTwo<numberThree){
                System.out.println(numberTwo);
            }else {
                System.out.println(numberThree);
            }
        }
    }
}
