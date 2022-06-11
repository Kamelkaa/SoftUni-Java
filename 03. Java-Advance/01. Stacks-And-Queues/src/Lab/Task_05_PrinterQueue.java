package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> fileQueue = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (!input.equals("cancel")) {
                fileQueue.offer(input);
            } else {
                if (!fileQueue.isEmpty()) {
                    String canceledFile = fileQueue.poll();
                    System.out.printf("Canceled %s%n", canceledFile);
                } else {
                    System.out.println("Printer is on standby");
                }
            }

            input = scanner.nextLine();
        }

        for (String file : fileQueue) {
            System.out.println(file);
        }
    }
}
