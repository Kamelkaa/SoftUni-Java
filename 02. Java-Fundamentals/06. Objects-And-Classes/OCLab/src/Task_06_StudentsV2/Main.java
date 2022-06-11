package Task_06_StudentsV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<StudentTwo> students = new ArrayList<>();
        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] studentInformation = line.split(" ");

            String firstName = studentInformation[0];
            String lastName = studentInformation[1];
            int age = Integer.parseInt(studentInformation[2]);
            String city = studentInformation[3];

            if (isStudentExisting(students, firstName, lastName)) {
                StudentTwo studentTwo = getStudent(students, firstName, lastName);
                studentTwo.setFirstName(firstName);
                studentTwo.setLastName(lastName);
                studentTwo.setAge(age);
                studentTwo.setHometown(city);
            } else {
                StudentTwo studentTwo = new StudentTwo(firstName, lastName, age, city);
                students.add(studentTwo);
            }

            line = scanner.nextLine();
        }

        String cityName = scanner.nextLine();

        for (StudentTwo student : students) {
            if (student.getHometown().equals(cityName)) {
                //{firstName} {lastName} is {age} years old..
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    private static boolean isStudentExisting(List<StudentTwo> students, String firstName, String lastName) {
        for (StudentTwo student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    private static StudentTwo getStudent(List<StudentTwo> students, String firstName, String lastName) {
        StudentTwo existingStudent = null;

        for (StudentTwo student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }

        return existingStudent;
    }
}
