package Exercise;

import java.util.Scanner;

public class Task_01_OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameBook = scanner.nextLine();
        String input = scanner.nextLine();
        int counter = 0;

        while (!input.equals(nameBook) && !input.equals("No More Books")) {
            counter++;
            input = scanner.nextLine();
        }

        if (input.equals(nameBook)) {
            System.out.printf("You checked %d books and found it.", counter);
        } else if (input.equals("No More Books")) {
            System.out.printf("The book you search is not here!%nYou checked %d books.", counter);
        }
    }
}
