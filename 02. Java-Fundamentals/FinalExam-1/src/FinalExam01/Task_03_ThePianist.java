package FinalExam01;

import java.util.*;


public class Task_03_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeaces = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> peaces = new TreeMap<>();

        for (int i = 0; i < numberOfPeaces; i++) {
            String[] peacesComposersKeys = scanner.nextLine().split("\\|");
            String piece = peacesComposersKeys[0];
            String composer = peacesComposersKeys[1];
            String key = peacesComposersKeys[2];

            peaces.put(piece, Arrays.asList(composer, key)); //0 -> compositor, 1 -> key
        }

        String commandsInput = scanner.nextLine();
        while (!commandsInput.equals("Stop")) {
            String[] types = commandsInput.split("\\|");
            String commandType = types[0];
            String namePiece = types[1];

            switch (commandType) {
                case "Add":
                    String composerName = types[2];
                    String keyName = types[3];

                    if (peaces.containsKey(namePiece)) {
                        System.out.printf("%s is already in the collection!%n", namePiece);
                    } else {
                        System.out.printf("%s by %s in %s added to the collection!%n", namePiece, composerName, keyName);
                        peaces.put(namePiece, Arrays.asList(composerName, keyName));
                    }
                    break;
                case "Remove":
                    if (peaces.containsKey(namePiece)) {
                        System.out.printf("Successfully removed %s!%n", namePiece);
                        peaces.remove(namePiece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", namePiece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = types[2];

                    if (peaces.containsKey(namePiece)) {
                        System.out.printf("Changed the key of %s to %s!%n", namePiece, newKey);
                        peaces.get(namePiece).set(1, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", namePiece);
                    }
                    break;
            }

            commandsInput = scanner.nextLine();
        }

        peaces.forEach((key, value) -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                key, value.get(0), value.get(1)));
    }
}
//.sorted((e1, e2) -> {
//int result = e1.getKey().compareTo(e2.getKey());

// if (e2.getKey().equals(e1.getKey())) {
//    result = e2.getValue().get(0).compareTo(e1.getValue().get(0));
//  }
//  return result;
// })