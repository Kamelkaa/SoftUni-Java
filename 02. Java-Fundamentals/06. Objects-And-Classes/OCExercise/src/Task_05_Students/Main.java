package Task_05_Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String[] dataPerStudent = scanner.nextLine().split("\\s+");

            //Lakia Eason 3.90
            String firstName = dataPerStudent[0];
            String secondName = dataPerStudent[1];
            double grade = Double.parseDouble(dataPerStudent[2]);

            Student student = new Student(firstName, secondName, grade);
            students.add(student);
        }

        students.sort(Comparator.comparing(Student::getGrade).reversed());

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
