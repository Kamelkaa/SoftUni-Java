package Exercise;

import java.util.Scanner;

public class Task_01_Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeProjection = scanner.nextLine();
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int hall = c * r;
        double fullHall = 0;

        switch (typeProjection) {
            case "Premiere":
                fullHall = hall * 12;
                break;
            case "Normal":
                fullHall = hall * 7.50;
                break;
            case "Discount":
                fullHall = hall * 5;
                break;
        }

        System.out.printf("%.2f", fullHall);
    }
}
