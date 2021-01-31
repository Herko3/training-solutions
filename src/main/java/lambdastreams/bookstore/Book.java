package lambdastreams.bookstore;

public class Book {

    private String title;
    private int yearOfPublish;
    private int price;
    private int quantity;

    public Book(String title, int yearOfPublish, int price, int quantity) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
