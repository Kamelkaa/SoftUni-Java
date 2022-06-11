package Task_02_Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(scanner.nextLine());

        String title = input[0];
        String content = input[1];
        String author = input[2];

        Article article = new Article(title, content, author);

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            //"Edit: {new content}"
            //"ChangeAuthor: {new author}"
            //"Rename: {new title}".
            String typeOfCommand = command.split(": ")[0];
            String newData = command.split(": ")[1];

            switch (typeOfCommand) {
                case "Edit":
                    article.edit(newData);
                    break;

                case "ChangeAuthor":
                    article.changeAuthor(newData);
                    break;

                case "Rename":
                    article.rename(newData);
                    break;
            }
        }

        System.out.println(article);
    }
}
