package Task_04_Articles_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<ArticleTwo> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            //Science, planets, Bill
            String title = command.split(", ")[0];
            String content = command.split(", ")[1];
            String author = command.split(", ")[2];

            ArticleTwo article = new ArticleTwo(title, content, author);

            articles.add(article);
        }

        String criteria = scanner.nextLine();

        switch (criteria) {
            case "title":
                articles.sort(Comparator.comparing(ArticleTwo::getTitle));
                break;

            case "content":
                articles.sort(Comparator.comparing(ArticleTwo::getContent));
                break;

            case "author":
                articles.sort(Comparator.comparing(ArticleTwo::getAuthor));
                break;
        }

        for (ArticleTwo article : articles) {
            System.out.println(article);
        }

    }
}
