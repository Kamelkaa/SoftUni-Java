package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Task_03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();

        while (numberOfLines-- > 0) {
            String[] listOfElements = scanner.nextLine().split("\\s+");

            Collections.addAll(elements, listOfElements);
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
