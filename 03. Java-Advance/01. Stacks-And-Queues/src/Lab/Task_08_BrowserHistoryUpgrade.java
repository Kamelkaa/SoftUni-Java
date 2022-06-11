package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stackBrowserURLsHistory = new ArrayDeque<>();
        ArrayDeque<String> queueForward = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stackBrowserURLsHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    queueForward.addFirst(stackBrowserURLsHistory.peek());
                    stackBrowserURLsHistory.pop();
                    System.out.println(stackBrowserURLsHistory.peek());
                }

            } else if (input.equals("forward")) {
                if (queueForward.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(queueForward.peek());
                    stackBrowserURLsHistory.push(queueForward.pop());
                }
            } else {
                System.out.println(input);
                stackBrowserURLsHistory.push(input);
                queueForward.clear();
            }

            input = scanner.nextLine();
        }
    }
}
