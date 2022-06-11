package exam08_14April2021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    //⦁	capacity: int
    //⦁	students: List<Student>
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    //⦁	getStudentCount() method– returns the number of students in the university
    public int getStudentCount() {
        return this.students.size();
    }

    //⦁	registerStudent(Student student) method – adds an entity to the students if there is room for it
    public String registerStudent(Student student) {
        if (students.contains(student)) {
            return "Student is already in the university";
        }
        if (this.students.size() < this.capacity) {
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return ("No seats in the university");
        }
    }

    //⦁	dismissStudent(Student student) method – removes the student
    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    //⦁	getStudent(String firstName, String lastName) method - returns the student with the given names.
    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return new Student("NoFirstName", "NoLastName", "NoBestSubject");
    }

    //⦁	getStatistics() – returns a String in the following format:
    //⦁	"==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
    // ==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();

        for (Student student : students) {
            builder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.getFirstName(), student.getLastName(), student.getBestSubject()))
                    .append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
