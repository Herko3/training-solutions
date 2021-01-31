package lambdastreams.bookstore;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {

    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public int getNumberOfBooks() {
        return books.stream().reduce(0, (i, b) -> i + b.getQuantity(), Integer::sum);
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max(Comparator.comparingInt(Book::getYearOfPublish));
    }

    public int getTotalValue() {
        return books.stream().reduce(0, (i, b) -> i + (b.getPrice() * b.getQuantity()), Integer::sum);
    }

    public List<Book> getByYearOfPublish(int year){
        Map<Integer,List<Book>> map = books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish));
        return map.get(year);
    }
}
