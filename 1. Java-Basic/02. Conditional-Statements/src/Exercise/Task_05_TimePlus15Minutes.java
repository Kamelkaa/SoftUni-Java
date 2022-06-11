package Exercise;

import java.util.Scanner;

public class Task_05_TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int allMinutes = hour * 60 + minutes;
        int minutesAfter15Min = allMinutes + 15;
        int finalHour = minutesAfter15Min / 60;
        int finalMinutes = minutesAfter15Min % 60;

        if (finalHour >= 24) {
            finalHour = finalHour - 24;
        }

        System.out.printf("%d:%02d", finalHour, finalMinutes);
    }
}
