package Lab;

import java.util.*;

public class Task_05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfStudents = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> studentsAndGrades = new TreeMap<>();

        for (int i = 0; i < numbersOfStudents; i++) {
            String[] studentAndGrade = scanner.nextLine().split("\\s+");
            String studentName = studentAndGrade[0];
            double grade = Double.parseDouble(studentAndGrade[1]);

            List<Double> grades = new LinkedList<>();
            if (studentsAndGrades.containsKey(studentName)) {
                grades = studentsAndGrades.get(studentName);
            }

            grades.add(grade);
            studentsAndGrades.put(studentName, grades);
        }

        studentsAndGrades.forEach((k, v) -> {
            StringBuilder builder = new StringBuilder();
            v.forEach(e -> builder.append(String.format("%.2f ", e)));

            double avg = 0;
            if (v.isEmpty()) {
                avg = 0;
            }
            for (Double element : v) {
                avg += element;
            }
            avg /= v.size();

            System.out.printf("%s -> %s(avg: %.2f)%n", k, builder, avg);
        });
    }
}
