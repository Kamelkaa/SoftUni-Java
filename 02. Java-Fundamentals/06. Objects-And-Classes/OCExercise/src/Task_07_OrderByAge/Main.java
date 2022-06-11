package Task_07_OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Person> people = new ArrayList<>();

        while (!input.equals("End")) {
            //Georgi 123456 20
            String name = input.split("\\s+")[0];
            String id = input.split("\\s+")[1];
            int age = Integer.parseInt(input.split("\\s+")[2]);

            Person person = new Person(name, id, age);
            people.add(person);

            input = scanner.nextLine();
        }

        people.sort(Comparator.comparing(Person::getAge));

        for (Person person : people) {
            System.out.print(person);
        }
    }
}
