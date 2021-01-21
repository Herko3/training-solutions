package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        Iterator<Book> cursor = libraryBooks.iterator();

        while(cursor.hasNext()) {
            Book book = cursor.next();
            if (book.getRegNumber() == regNumber) {
                return book;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
        Iterator<Book> cursor = libraryBooks.iterator();

        while (cursor.hasNext()) {
            Book book = cursor.next();
            if (book.getRegNumber() == regNumber) {
                cursor.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> found = new HashSet<>();
        Iterator<Book> cursor = libraryBooks.iterator();

        while (cursor.hasNext()) {
            Book book = cursor.next();
            if (book.getAuthor().equals(author)) {
                found.add(book);
            }
        }

        if (found.isEmpty()) {
            throw new MissingBookException("No books found by " + author);
        }
        return found;
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }

}
