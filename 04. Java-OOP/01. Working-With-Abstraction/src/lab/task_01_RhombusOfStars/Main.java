package lab.task_01_RhombusOfStars;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int size = readInput();
        String rhombusOfStars = new RhombusOfStars(size).buildString();
        printOutput(rhombusOfStars);
    }

    private static int readInput() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    private static void printOutput(String rhombusOfStars) {
        System.out.println(rhombusOfStars);
    }
}
