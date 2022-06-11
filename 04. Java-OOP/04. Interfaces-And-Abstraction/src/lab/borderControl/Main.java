package lab.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Identifiable> detainedIds = new ArrayList<>();

        while (!input.equals("End")) {
            String[] infoForWhoTriedToEnter = input.split("\\s+");

            Identifiable identifiable;
            if (infoForWhoTriedToEnter.length == 2) {
                identifiable = new Robot(infoForWhoTriedToEnter[0], infoForWhoTriedToEnter[1]);
            } else {
                identifiable = new Citizen(infoForWhoTriedToEnter[0], Integer.parseInt(infoForWhoTriedToEnter[1])
                        , infoForWhoTriedToEnter[2]);
            }

            detainedIds.add(identifiable);
            input = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();
        for (Identifiable detainedId : detainedIds) {
            String id = detainedId.getId();
            if (id.endsWith(fakeId)) {
                System.out.println(id);
            }
        }
    }
}
