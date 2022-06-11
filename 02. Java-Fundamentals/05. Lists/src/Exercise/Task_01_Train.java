package Exercise;

import com.sun.jdi.IntegerValue;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");

            if (command.length > 1) {
                int newWagonWithPassengers = Integer.parseInt(command[1]);
                wagons.add(newWagonWithPassengers);
            } else {
                int passengers = Integer.parseInt(command[0]);
                for (int i = 0; i <= wagons.size() - 1; i++) {
                    int passengersInWagon = wagons.get(i);
                    if (passengersInWagon + passengers <= maxCapacity) {
                        wagons.set(i, passengersInWagon + passengers);
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }

        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
