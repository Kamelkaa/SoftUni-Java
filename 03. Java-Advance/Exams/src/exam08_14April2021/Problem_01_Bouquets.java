package exam08_14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem_01_Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tulips::push);

        ArrayDeque<Integer> daffodils = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int sumOfLeftFlowers = 0;
        int bouquets = 0;
        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int lily = tulips.pop();
            int rose = daffodils.poll();
            int sum = lily + rose;

            if (sum > 15) {
                sum = getSum(sum, lily, rose);
            }
            if (sum == 15) {
                bouquets++;
            }
            if (sum < 15) {
                sumOfLeftFlowers += sum;
            }
        }

        if (sumOfLeftFlowers > 0 && sumOfLeftFlowers / 15 > 0) {
            bouquets += sumOfLeftFlowers / 15;
        }
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            int neededWreath = 5 - bouquets;
            System.out.printf("You failed... You need more %d bouquets.", neededWreath);
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
