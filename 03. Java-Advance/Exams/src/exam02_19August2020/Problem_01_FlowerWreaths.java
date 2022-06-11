package exam02_19August2020;

import java.util.*;
import java.util.stream.Collectors;

public class Problem_01_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(liliesStack::push);

        ArrayDeque<Integer> rosesQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int sumOfLeftFlowers = 0;
        int wreath = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int lily = liliesStack.pop();
            int rose = rosesQueue.poll();
            int sum = lily + rose;

            if (sum > 15) {
                sum = getSum(sum, lily, rose);
            }
            if (sum == 15) {
                wreath++;
            }
            if (sum < 15) {
                sumOfLeftFlowers += sum;
            }
        }

        if (sumOfLeftFlowers > 0 && sumOfLeftFlowers / 15 > 0) {
            wreath += sumOfLeftFlowers / 15;
        }
        if (wreath >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreath);
        } else {
            int neededWreath = 5 - wreath;
            System.out.printf("You didn't make it, you need %d wreaths more!", neededWreath);
        }
    }

    private static int getSum(int sum, int lily, int rose) {
        while (sum > 15) {
            sum = (lily - 2) + rose;
            lily -= 2;
        }
        return sum;
    }
}
