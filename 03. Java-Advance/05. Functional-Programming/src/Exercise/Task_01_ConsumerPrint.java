package Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class Task_01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        Consumer<String[]> print = stringArray -> {
            for (String name : stringArray) {
                System.out.println(name);
            }
        };

        print.accept(names);
    }
}
