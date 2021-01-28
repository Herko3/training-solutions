package week13.d03;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookManagerTest {

    @Test
    void testMaxNumber(){
        List<Book> books = Arrays.asList(
                new Book("Jack","title",12),
                new Book("Jack","title",12),
                new Book("Jack","title",10),
                new Book("John","title",12),
                new Book("Joe","title",9),
                new Book("Joe","title",12),
                new Book("Joe","title",8),
                new Book("Jane","title",11)
        );

        assertEquals("Jack",new BookManager(books).maxPages());

    }

}