package searching;

public class Book implements Comparable<Book> {

    private int id;
    private String title;
    private String author;

    public Book(int id, String author, String title) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(String author, String title) {
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book o) {
        int compare = author.compareTo(o.author);
        if (compare == 0) {
            return title.compareTo(o.title);
        }
        return compare;
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }
}
