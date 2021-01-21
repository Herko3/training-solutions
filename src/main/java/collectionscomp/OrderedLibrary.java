package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {

    private List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle() {
        List<Book> ordered = new ArrayList<>(libraryBooks);
        Collections.sort(ordered);
        return ordered;
    }

    public List<Book> orderedByAuthor() {
        List<Book> ordered = new ArrayList<>(libraryBooks);

        Collections.sort(ordered, new Comparator<>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });

        return ordered;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> ordered = new ArrayList<>();

        for (Book book : libraryBooks) {
            ordered.add(book.getTitle());
        }

        Collections.sort(ordered, Collator.getInstance(locale));
        return ordered;
    }

}
