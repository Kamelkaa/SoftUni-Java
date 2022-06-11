package Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task_06_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        String resource = "";

        while (!(resource = scanner.nextLine()).equals("stop")) {
            int number = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(resource)) {
                resources.put(resource, number);
            } else {
                resources.put(resource, (resources.get(resource) + number));
            }
        }

        resources.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
