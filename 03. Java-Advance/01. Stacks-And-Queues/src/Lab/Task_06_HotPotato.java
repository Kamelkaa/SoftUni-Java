package Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Task_06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] players = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queuePlayers = new ArrayDeque<>();

        // for (String player : players) {
        //  queuePlayers.offer(player);
        //  }
        Collections.addAll(queuePlayers, players);

        int n = Integer.parseInt(scanner.nextLine());

        while (queuePlayers.size() > 1) {
            for (int i = 1; i < n; i++) {
                queuePlayers.offer(queuePlayers.poll());
            }

            System.out.println("Removed " + queuePlayers.poll());
        }

        System.out.println("Last is " + queuePlayers.poll());
    }
}
