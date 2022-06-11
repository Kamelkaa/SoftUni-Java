package MidExam02;

import java.util.Arrays;
import java.util.Scanner;

public class Task_02_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersInArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String text = scanner.nextLine();
        while (!text.equals("end")) {
            String command = text.split(" ")[0];

            switch (command) {
                case "swap":
                    int indexOne = Integer.parseInt(text.split(" ")[1]);
                    int indexTwo = Integer.parseInt(text.split(" ")[2]);

                    int currentIndex = numbersInArray[indexOne];
                    numbersInArray[indexOne] = numbersInArray[indexTwo];
                    numbersInArray[indexTwo] = currentIndex;
                    break;

                case "multiply":
                    indexOne = Integer.parseInt(text.split(" ")[1]);
                    indexTwo = Integer.parseInt(text.split(" ")[2]);

                    int multiplyIndex = numbersInArray[indexOne] * numbersInArray[indexTwo];
                    numbersInArray[indexOne] = multiplyIndex;

                    break;
                case "decrease":
                    for (int i = 0; i < numbersInArray.length; i++) {
                        numbersInArray[i] -= 1;
                    }

                    break;
            }

            text = scanner.nextLine();
        }

        String[] stringArray = Arrays.stream(numbersInArray)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        System.out.println(String.join(", ", stringArray));
    }
}
