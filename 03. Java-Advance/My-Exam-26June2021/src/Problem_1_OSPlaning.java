import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem_1_OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskToBeKilled = Integer.parseInt(scanner.nextLine());
        int thread = threads.peek();
        int task = tasks.peek();

        while (task != taskToBeKilled) {
            if (thread >= task) {
                tasks.pop();
            }
            threads.poll();

            task = tasks.peek();
            thread = threads.peek();
        }

        System.out.printf("Thread with value %d killed task %d%n", threads.peek(), taskToBeKilled);
        System.out.println(getElementsInfo(threads));
    }

    private static String getElementsInfo(ArrayDeque<Integer> array) {
        return array.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
