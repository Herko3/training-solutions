package iofilestest.library;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> booksList = new ArrayList<>();

    public void add(Book... books) {
        for (Book book : books) {
            booksList.add(book);
        }
    }

    public void saveBooks(Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Book book : booksList) {
                writer.write(book.getAuthor());
                writer.write(" - ");
                writer.write(book.getTitle() + "\n");
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }

    }

    public void loadBooks(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String parts[] = line.split(" - ");
                booksList.add(new Book(parts[0],parts[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public List<Book> getBooksList() {
        return new ArrayList<>(booksList);
    }
}
