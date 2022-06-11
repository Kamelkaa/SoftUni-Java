package Exercise;

import java.util.Scanner;

public class Task_09_VolleyballSTAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeYear = scanner.nextLine();
        int numberOfHolidays = Integer.parseInt(scanner.nextLine());
        int weekendsInProvince = Integer.parseInt(scanner.nextLine());

        int weekendsInSofia = 48 - weekendsInProvince;
        double gamesInSofia = weekendsInSofia * 1.0 * 3 / 4;
        double gamesHolidays = numberOfHolidays * 1.0 * 2 / 3;
        double totalGames = gamesInSofia + gamesHolidays + weekendsInProvince;

        if (typeYear.equals("leap")) {
            totalGames = totalGames + totalGames * 0.15;
        }

        System.out.printf("%.0f", Math.floor(totalGames));
    }
}
