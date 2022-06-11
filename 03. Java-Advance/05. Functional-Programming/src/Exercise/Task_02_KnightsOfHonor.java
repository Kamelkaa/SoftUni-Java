package Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class Task_02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        Consumer<String[]> print = stringArray -> {
            for (String name : stringArray) {
                System.out.println("Sir " + name);
            }
        };

        print.accept(names);
    }
}
