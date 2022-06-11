package exercise.task_02_CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];

            Employee employee = null;
            if (employeeData.length == 6) {
                String email = employeeData[4];
                int age = Integer.parseInt(employeeData[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (employeeData.length == 5) {
                String lastData = employeeData[4];
                if (lastData.contains("@")) {
                    String email = lastData;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(lastData);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (employeeData.length == 4) {
                employee = new Employee(name, salary, position, department);
            }

            if (!departments.containsKey(department)) {
                departments.put(department, new Department(department));
            }
            departments.get(department).getEmployees().add(employee);
        }

        Department highestAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparing(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + highestAverageSalaryDepartment.getName());
        highestAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
