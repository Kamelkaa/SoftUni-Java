package Exercise;

import java.util.*;

public class Task_06_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> courses = new LinkedHashMap<>();
        while (!input.equals("end")) {
            String[] coursesAndStudents = input.split(" : ");
            String courseName = coursesAndStudents[0];
            String studentName = coursesAndStudents[1];

            courses.putIfAbsent(courseName, new ArrayList<>());
            courses.get(courseName).add(studentName);

            input = scanner.nextLine();
        }

        courses.entrySet().stream()
                .sorted((n1, n2) -> Integer.compare(n2.getValue().size(), n1.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(e -> System.out.printf("-- %s%n", e));
                });
    }
}
