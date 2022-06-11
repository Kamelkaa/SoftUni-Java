package exercise.task_04_TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] colors = scanner.nextLine().split("\\s+");
        int countChangeColor = Integer.parseInt(scanner.nextLine());

        List<LightBulb> lightBulbList = new ArrayList<>();
        Arrays.stream(colors).forEach(color -> {
            LightBulb lightBulb = new LightBulb(Color.valueOf(color));
            lightBulbList.add(lightBulb);
        });

        for (int i = 0; i < countChangeColor; i++) {
            lightBulbList.forEach(lightBulb -> {
                lightBulb.changeColor();
                System.out.print(lightBulb.getColor() + " ");
            });
            System.out.println();
        }
    }
}
