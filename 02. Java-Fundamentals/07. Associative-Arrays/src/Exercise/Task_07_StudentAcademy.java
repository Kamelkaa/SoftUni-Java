package Exercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_07_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPear = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentsAndGrades = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPear; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsAndGrades.containsKey(studentName)) {
                studentsAndGrades.put(studentName, grade);
            } else {
                studentsAndGrades.put(studentName, (studentsAndGrades.get(studentName) + grade) / 2);
            }
        }

        studentsAndGrades.entrySet().stream()
                .filter(entry -> entry.getValue() >= 4.50)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(pear -> System.out.printf("%s -> %.2f%n", pear.getKey(), pear.getValue()));
    }
}
