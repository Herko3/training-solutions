package filescanner;

public class Book {

    private String regNumber;
    private String author;
    private String title;
    private int yearOfPublish;

    public Book(String regNumber, String author, String title, int yearOfPublish) {
        this.regNumber = regNumber;
        this.author = author;
        this.title = title;
        this.yearOfPublish = yearOfPublish;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }
}
