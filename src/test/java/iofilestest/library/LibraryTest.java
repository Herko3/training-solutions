package iofilestest.library;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {


    @TempDir
    public File folder;

    @Test
    public void testSaveBooks() throws IOException {
        File file = new File(folder, "test.txt");
        Path path = file.toPath();

        Library library = new Library();
        library.add(new Book("Stephen King", "Búra"),
                new Book("Stephen King", "Búra2"));

        library.saveBooks(path);

        List<String> content = Files.readAllLines(path);
        assertEquals(2, content.size());
        assertEquals("Stephen King - Búra2", content.get(1));
    }

    @Test
    public void testLoadBooks() {
        Path path = Path.of("src/main/resources/iofilestest/library/books.txt");
        Library library = new Library();
        library.loadBooks(path);

        assertEquals(3,library.getBooksList().size());
        assertEquals("Lawrence Block",library.getBooksList().get(1).getAuthor());
        assertEquals("The burglar 2.",library.getBooksList().get(1).getTitle());
    }

}