package attributes.book;

public class BookMain {

    public static void main(String[] args) {
        Book book = new Book("Dr. Who");

        System.out.println(book.getTitle());
        book.setTitle("Sherlock Holmes");
        System.out.println(book.getTitle());
    }
}
