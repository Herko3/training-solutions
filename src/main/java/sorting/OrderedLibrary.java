package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderedLibrary {

    private Set<Book> library;

    public OrderedLibrary(Set<Book> library) {
        this.library = library;
    }

    public Book lendFirstBook(){
        if(library == null || library.isEmpty()){
            throw new NullPointerException("Libray is empty!");
        }
        List<Book> lib = new ArrayList<>(library);
        return lib.get(0);
    }
}
