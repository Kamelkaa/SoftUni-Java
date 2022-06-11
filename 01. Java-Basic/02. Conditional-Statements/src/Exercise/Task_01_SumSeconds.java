package Exercise;

import java.util.Scanner;

public class Task_01_SumSeconds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstTime = Integer.parseInt(scanner.nextLine());
        int secondTime = Integer.parseInt(scanner.nextLine());
        int thirdTime = Integer.parseInt(scanner.nextLine());

        int sumTime = firstTime + secondTime + thirdTime;
        int minutes = sumTime / 60;
        int seconds = sumTime % 60;

        System.out.printf("%d:%02d", minutes, seconds);
    }
}
