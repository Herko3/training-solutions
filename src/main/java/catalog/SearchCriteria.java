package catalog;

public class SearchCriteria {

    public String contributor;
    public String title;

    private SearchCriteria(String title, String contributor) {
        this.contributor = contributor;
        this.title = title;
    }

    public static SearchCriteria createByBoth(String contributor, String title) {
        if (Validators.isBlank(contributor) || Validators.isBlank(title)) {
           throw new IllegalArgumentException("Contributor and title must be filled");
        }
        return new SearchCriteria(contributor, title);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Contributor must be something");
        }
        return new SearchCriteria(null, contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title must be something");
        }
        return new SearchCriteria(title, null);
    }

    public boolean hasContributor() {
        return !(contributor == null || contributor.isBlank());
    }

    public boolean hasTitle() {
        return !(title == null || title.isBlank());
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }
}
