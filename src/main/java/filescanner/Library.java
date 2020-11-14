package filescanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void loadFromFile() {
        try (Scanner scanner = new Scanner(Library.class.getResourceAsStream("/books.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lines = new Scanner(line).useDelimiter(";|(\r\n)");
                String regNumber = lines.next();
                String author = lines.next();
                String title = lines.next();
                int yearOfPublish = lines.nextInt();
                books.add(new Book(regNumber,author,title,yearOfPublish));
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
