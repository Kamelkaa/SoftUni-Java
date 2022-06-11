package Lab;

import java.util.*;

public class Task_08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> graduationList = new TreeMap<>();

        while (numbersOfStudents-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            graduationList.put(name, grades);
        }

        graduationList.forEach((k, v) -> {
            double avg = 0;
            if (v.length == 0) {
                avg = 0;
            }
            for (double element : v) {
                avg += element;
            }

            avg /= v.length;

            System.out.println(k + " is graduated with " + avg);
        });
    }
}
