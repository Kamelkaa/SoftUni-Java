package lab.gettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Method[] declaredMethods = Reflection.class.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(method -> method.getName().startsWith("get") || method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(Main::print);
    }

    public static void print(Method method) {
        String out = method.getName().startsWith("set")
                ? String.format("%s and will set field of class %s",
                method.getName(), method.getParameterTypes()[0].getName())
                : String.format("%s will return class %s",
                method.getName(), method.getReturnType().getName());
        System.out.println(out);
    }
}
