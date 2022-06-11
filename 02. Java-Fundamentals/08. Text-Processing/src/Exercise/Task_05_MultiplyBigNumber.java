package Exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class Task_05_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();

        BigInteger numberOne = new BigInteger(firstNumber);
        BigInteger numberTwo = new BigInteger(secondNumber);

        System.out.println(numberOne.multiply(numberTwo));
    }
}
