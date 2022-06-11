package lab.task_03_StudentSystem;

import java.util.Scanner;

public class StudentSystem {
    private StudentRepository repository;
    private CommandHandler handler;
    private boolean isWorking;

    public StudentSystem() {
        this.repository = new StudentRepository();
        this.handler = new CommandHandler();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        this.isWorking = true;
        while (isWorking) {
            String result = handler.handleCommand(scanner.nextLine().split("\\s+"));

            if (result != null && !result.equals("Exit")) {
                System.out.println(result);
            }

            isWorking = !"Exit".equals(result);
        }
    }
}
