package Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Task_07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] players = scanner.nextLine().split("\\s+");

        ArrayDeque<String> queuePlayers = new ArrayDeque<>();
        Collections.addAll(queuePlayers, players);

        int n = Integer.parseInt(scanner.nextLine());

        int cycle = 1;
        while (queuePlayers.size() > 1) {
            for (int i = 1; i < n; i++) {
                queuePlayers.offer(queuePlayers.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + queuePlayers.peek());
            } else {
                System.out.println("Removed " + queuePlayers.poll());
            }

            cycle++;
        }

        System.out.println("Last is "+ queuePlayers.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle == 1) {
            return false;
        }

        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }

        return true;
    }
}
