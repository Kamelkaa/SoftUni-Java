package lab.task_02_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rectanglePoints = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();   //Reader.readIntArray("\\s+");

        Point a = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point b = new Point(rectanglePoints[2], rectanglePoints[3]);

        Rectangle rectangle = new Rectangle(a, b);

        int count = Integer.parseInt(scanner.nextLine());   //Reader.readIntArray("\\s+")[0];
        while (count-- > 0) {
            int[] singlePoint = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();   //Reader.readIntArray("\\s+");
            Point p = new Point(singlePoint[0], singlePoint[1]);

            boolean isWithin = rectangle.contains(p);

            System.out.println(isWithin);
        }
    }
}
