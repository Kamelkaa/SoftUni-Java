package lab.highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Field[] declaredFields = Reflection.class.getDeclaredFields();

        Arrays.stream(declaredFields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        Method[] declaredMethods = Reflection.class.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(method -> method.getName().startsWith("get") || method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(Main::print);
    }

    public static void print(Method method) {
        String out;
        if (method.getName().startsWith("set") && !Modifier.isPrivate(method.getModifiers())) {
            out = String.format("%s have to be private!", method.getName());
        } else if (method.getName().startsWith("get") && !Modifier.isPublic(method.getModifiers())) {
            out = String.format("%s have to be public!", method.getName());
        } else {
            return;
        }
        System.out.println(out);
    }
}
