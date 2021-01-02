package catalog;

import java.util.ArrayList;
import java.util.List;

public class PrintedFeatures implements Feature {

    private List<String> authors = new ArrayList<>();
    private final int numberOfPages;
    private final String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("Number of pages must be positive");
        }
        if (Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("Authors list must not be null");
        }

        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        return new ArrayList<>(authors);
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String getTitle() {
        return title;
    }

}
