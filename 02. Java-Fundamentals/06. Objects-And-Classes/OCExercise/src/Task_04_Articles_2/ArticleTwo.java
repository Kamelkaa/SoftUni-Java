package Task_04_Articles_2;

public class ArticleTwo {
    private String title;
    private String content;
    private String author;

    public ArticleTwo(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + " - " + content + ": " + author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}
