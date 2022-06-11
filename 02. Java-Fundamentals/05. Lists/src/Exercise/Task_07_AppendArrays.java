package Exercise;

import java.util.*;

public class Task_07_AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split("\\|");
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            String[] ch = s[i].split("\\s+");
            Collections.reverse(Arrays.asList(ch));

            for (int j = 0; j < ch.length; j++) {
                String current = ch[j];
                if (!"".equals(current)) {
                    list.add(current);
                }
            }
        }

        Collections.reverse(list);
        System.out.print(String.join(" ", list ));
    }
}

