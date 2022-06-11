package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task_05_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .limit(3)
                .forEach(n -> System.out.print(n + " "));
    }
}
