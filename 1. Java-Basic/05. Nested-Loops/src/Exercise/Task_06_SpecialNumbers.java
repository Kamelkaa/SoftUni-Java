package Exercise;

import java.util.Scanner;

public class Task_06_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1111; i <= 9999; i++) {

            boolean isZero = false;
            boolean isNotSpecialNumber = false;
            String current = "" + i;
            String noResidue = "";

            for (int j = 0; j < current.length(); j++) {
                int currentDigit = Integer.parseInt("" + current.charAt(j));
                if (currentDigit == 0) {
                    isZero = true;
                    break;
                }

                if (n % currentDigit == 0) {
                    noResidue += currentDigit + "";
                } else {
                    isNotSpecialNumber = true;
                    break;
                }
            }

            if (isZero) {
              continue;
            }

            if (!isNotSpecialNumber) {
                System.out.print(noResidue + " ");
            }
        }
    }
}
