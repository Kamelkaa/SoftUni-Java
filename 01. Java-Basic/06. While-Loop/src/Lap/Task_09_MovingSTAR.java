package Lap;

import java.util.Scanner;

public class Task_09_MovingSTAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        String boxes = scanner.nextLine();

        int volume = width * length * height;
        int boxKM = 0;

        while (!boxes.equals("Done")) {
            int box = Integer.parseInt(boxes);
            boxKM = boxKM + box;

            if (boxKM > volume) {
                int neededKM = boxKM - volume;

                System.out.printf("No more free space! You need %d Cubic meters more.", neededKM);
                break;
            }

            boxes = scanner.nextLine();
        }

        if (boxes.equals("Done")) {
            int leftKM = volume - boxKM;
            System.out.printf("%d Cubic meters left.", leftKM);
        }
    }
}
