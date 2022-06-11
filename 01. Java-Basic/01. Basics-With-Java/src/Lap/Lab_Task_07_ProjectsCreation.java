package Lap;

import java.util.Scanner;

public class Lab_Task_07_ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameArchitect = scanner.nextLine();
        int numberOfProjects = Integer.parseInt(scanner.nextLine());
        int requiredHours = numberOfProjects * 3;

        System.out.printf("The architect %s will need %d hours to complete %d project/s.",
                nameArchitect, requiredHours, numberOfProjects);
    }
}
