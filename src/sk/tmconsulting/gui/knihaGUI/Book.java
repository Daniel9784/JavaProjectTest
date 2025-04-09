package sk.tmconsulting.gui.knihaGUI;

public class Book {
    private String title;
    private String description;
    private Author author;

    public Book(String title, String description, Author autor) {
        this.title = title;
        this.description = description;
        this.author = autor;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Author getAuthor() {
        return author;
    }
}
