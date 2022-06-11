package input;

import java.util.Arrays;
import java.util.Scanner;

public class Reader {

    public static int[] readIntArray(String delimiter) {
        return Arrays.stream(new Scanner(System.in).nextLine().split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
