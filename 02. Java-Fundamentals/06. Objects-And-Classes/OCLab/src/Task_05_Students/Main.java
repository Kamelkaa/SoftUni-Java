package Task_05_Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] studentInformation = line.split(" ");

            String firstName = studentInformation[0];
            String lastName = studentInformation[1];
            int age = Integer.parseInt(studentInformation[2]);
            String city = studentInformation[3];

            Student student = new Student(firstName, lastName, age, city);
            students.add(student);

            line = scanner.nextLine();
        }

        String cityName = scanner.nextLine();

        for (Student student : students) {
            if (student.getHomeTown().equals(cityName)) {
                //{firstName} {lastName} is {age} years old..
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
