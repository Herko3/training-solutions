package week13.d03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookManager {

    private Map<String,Integer> pagesByAuthor = new HashMap<>();

    public BookManager(List<Book> books){
        for(Book book : books){
            if(pagesByAuthor.containsKey(book.getAuthor())){
                int newPageNumber = pagesByAuthor.get(book.getAuthor()) + book.getNumberOfPages();
                pagesByAuthor.replace(book.getAuthor(), newPageNumber);
            } else {
                pagesByAuthor.put(book.getAuthor(), book.getNumberOfPages());
            }
        }
    }

    public String maxPages(){
        int maxNumberOfPages = 0;
        String author = null;
        for(Map.Entry<String,Integer> entry : pagesByAuthor.entrySet()){
            if(entry.getValue() > maxNumberOfPages){
                maxNumberOfPages = entry.getValue();
                author = entry.getKey();
            }
        }

        return author;
    }

}
