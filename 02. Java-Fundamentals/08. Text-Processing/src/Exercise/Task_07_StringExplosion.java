package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_07_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        int strengthBomb = 0;

        //abv>1>1>2>2asdasd
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(">") && strengthBomb > 0) {
                list.remove(i);
                strengthBomb--;
                i--;
            } else if (list.get(i).equals(">")) {
                strengthBomb += Integer.parseInt(list.get(i + 1));
            }
        }

        for (String s : list) {
            System.out.print(s);
        }
    }
}

