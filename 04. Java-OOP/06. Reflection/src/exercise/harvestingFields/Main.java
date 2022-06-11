package exercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Field> fields = Arrays.asList(RichSoilLand.class.getDeclaredFields());

        Map<String, List<Field>> fieldsMap = getFieldsMap(fields);
        fillMap(fields, fieldsMap);

        Consumer<Field> printer = field -> {
            StringBuilder builder = new StringBuilder();
            builder.append(Modifier.toString(field.getModifiers()))
                    .append(" ")
                    .append(field.getType().getSimpleName())
                    .append(" ")
                    .append(field.getName());
            System.out.println(builder);
        };

        String input = scanner.nextLine();
        while (!input.equals("HARVEST")) {
            switch (input) {
                case "public":
                    fieldsMap.get("public").forEach(printer);
                    break;
                case "private":
                    fieldsMap.get("private").forEach(printer);
                    break;
                case "protected":
                    fieldsMap.get("protected").forEach(printer);
                    break;
                case "all":
                    fieldsMap.get("all").forEach(printer);
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static void fillMap(List<Field> fields, Map<String, List<Field>> fieldsMap) {
        for (Field field : fields) {
            String modifier = Modifier.toString(field.getModifiers());
            switch (modifier) {
                case "public":
                    fieldsMap.get("public").add(field);
                    break;
                case "private":
                    fieldsMap.get("private").add(field);
                    break;
                case "protected":
                    fieldsMap.get("protected").add(field);
                    break;
            }
        }
    }

    private static Map<String, List<Field>> getFieldsMap(List<Field> fields) {
        Map<String, List<Field>> fieldsMap = new LinkedHashMap<>();
        fieldsMap.put("public", new ArrayList<>());
        fieldsMap.put("private", new ArrayList<>());
        fieldsMap.put("protected", new ArrayList<>());
        fieldsMap.put("all", fields);

        return fieldsMap;
    }
}
