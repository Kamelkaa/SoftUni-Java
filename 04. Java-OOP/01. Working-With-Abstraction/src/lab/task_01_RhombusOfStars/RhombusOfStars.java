package lab.task_01_RhombusOfStars;

import java.util.function.Predicate;

public class RhombusOfStars {
    private int size;

    public RhombusOfStars(int size) {
        this.size = size;
    }

    public String buildString() {
        return printMultipleRows(1, size, +1) +
                printMultipleRows(size - 1, 1, -1);
    }

    private String printMultipleRows(int start, int end, int step) {
        StringBuilder builder = new StringBuilder();
        Predicate<Integer> loopCondition = i -> {
            if (step > 0) {
                return i <= end;
            }
            return i >= end;
        };

        for (int r = start; loopCondition.test(r); r += step) {
            builder.append(printLine(size - r, r))
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }

    private String printLine(int spaces, int stars) {
        return " ".repeat(Math.max(0, spaces)) +
                "* ".repeat(Math.max(0, stars));
    }
}
