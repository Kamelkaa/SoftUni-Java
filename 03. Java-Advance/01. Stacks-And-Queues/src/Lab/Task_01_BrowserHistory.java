package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stackBrowserURLsHistory = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (!input.equals("back")) {
                stackBrowserURLsHistory.push(input);
                System.out.println(input);
            } else {
                if (stackBrowserURLsHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    stackBrowserURLsHistory.pop();
                    System.out.println(stackBrowserURLsHistory.peek());
                }
            }

            input = scanner.nextLine();
        }
    }
}
