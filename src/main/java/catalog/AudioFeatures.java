package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private List<String> composer;
    private int length;
    private List<String> performers;
    private String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title is empty");
        }
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("Performers List is empty");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }

        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this(title,length,performers);
        this.composer = composer;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        if (!Validators.isEmpty(composer)) {
            contributors.addAll(composer);
        }
        contributors.addAll(performers);
        return contributors;
    }
}
