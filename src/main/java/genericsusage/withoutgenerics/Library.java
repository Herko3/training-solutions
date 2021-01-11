package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List list){
        if(list == null){
            throw new NullPointerException();
        }
        if(list.size() == 0){
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        try{

        return (Book) list.get(0);
        } catch (ClassCastException e){
            throw new ClassCastException("Not a book");
        }
    }

}
