package Task_03_BigFactorial;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        BigInteger factorial = new BigInteger(String.valueOf(1));
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial.toString());
    }
}
