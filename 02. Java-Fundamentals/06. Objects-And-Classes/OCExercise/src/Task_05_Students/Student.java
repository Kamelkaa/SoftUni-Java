package Task_05_Students;

public class Student {
    private String firstName;
    private String secondName;
    private double grade;

    public Student(String firstName, String secondName, double grade) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.grade = grade;
    }

    @Override
    public String toString() {
        //{first name} {second name}: {grade}
        return String.format("%s %s: %.2f", firstName, secondName, grade);
    }

    public double getGrade() {
        return grade;
    }
}
