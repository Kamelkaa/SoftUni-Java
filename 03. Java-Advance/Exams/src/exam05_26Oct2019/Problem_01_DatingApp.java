package exam05_26Oct2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem_01_DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);
        ArrayDeque<Integer> femalesQueue = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matchesCount = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueue.peek();

            if (male > 0 && female > 0) {
                if (male % 25 != 0 && female % 25 != 0) {
                    malesStack.pop();
                    femalesQueue.poll();
                    if (male == female) {
                        matchesCount++;
                    } else {
                        malesStack.push(male - 2);
                    }
                } else {
                    if (male % 25 == 0) {
                        removeDivisibleBy25Stack(malesStack);
                    }
                    if (female % 25 == 0) {
                        removeDivisibleBy25Queue(femalesQueue);
                    }
                }
            } else {
                if (male <= 0) {
                    malesStack.pop();
                }
                if (female <= 0) {
                    femalesQueue.poll();
                }
            }
        }

        System.out.printf("Matches: %d%n", matchesCount);
        System.out.println("Males left: " + getElementsInfo(malesStack));
        System.out.println("Females left: " + getElementsInfo(femalesQueue));
    }

    private static void removeDivisibleBy25Stack(ArrayDeque<Integer> array) {
        if (array.size() > 1) {
            array.pop();
            array.pop();
        } else {
            array.pop();
        }
    }

    private static void removeDivisibleBy25Queue(ArrayDeque<Integer> array) {
        if (array.size() > 1) {
            array.poll();
            array.poll();
        } else {
            array.poll();
        }
    }

    private static String getElementsInfo(ArrayDeque<Integer> array) {
        return array.isEmpty()
                ? "none"
                : array.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
