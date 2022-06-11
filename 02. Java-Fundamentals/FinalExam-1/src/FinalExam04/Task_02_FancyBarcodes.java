package FinalExam04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfBarcodes = Integer.parseInt(scanner.nextLine());
        String regexValidBarcode = "@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+";

        for (int i = 0; i < countOfBarcodes; i++) {
            String barcode = scanner.nextLine();

            Pattern patternValidBarcode = Pattern.compile(regexValidBarcode);
            Matcher matcherValidBarcode = patternValidBarcode.matcher(barcode);

            if (matcherValidBarcode.find()) {
                String currentValidBarcode = matcherValidBarcode.group();
                String regexNumbersInBarcode = "\\d";

                Pattern patternNumbers = Pattern.compile(regexNumbersInBarcode);
                Matcher matcherNumbers = patternNumbers.matcher(currentValidBarcode);

                StringBuilder productGroup = new StringBuilder();
                while (matcherNumbers.find()) {
                    productGroup.append(matcherNumbers.group());
                }

                if (productGroup.toString().isEmpty()) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", productGroup.toString());
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
