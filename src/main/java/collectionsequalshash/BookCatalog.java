package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    //    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
//        Book search = new Book(title, author);
//        if (books.contains(new Book(search))) {
//            for (Book book : books) {
//                if (book.equals(new Book(title, author))) {
//                    return book;
//                }
//            }
//        }
//        return null;
//    }
//
//    public Book findBook(List<Book> books, Book book) {
//        if (books.contains(book)) {
//            for (Book b : books) {
//                if (b.equals(book)) {
//                    return book;
//                }
//            }
//        }
//        return null;
//    }

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        Book book = new Book(title, author);
        if (!books.contains(book)) {
            return null;
        }
        int index = books.indexOf(book);
        return books.get(index);
    }

    public Book findBook(List<Book> books, Book book) {
        if(!books.contains(book)){
            return null;
        }
        int index = books.indexOf(book);
        return books.get(index);
    }


    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> toSet = new HashSet<>();
        for (Book book : books) {
            toSet.add(book);
        }
        return toSet;
    }
}
