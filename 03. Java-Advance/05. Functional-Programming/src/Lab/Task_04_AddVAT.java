package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Task_04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Double> getVat = str ->
                Double.parseDouble(str) * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", "))
                .map(getVat)
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
