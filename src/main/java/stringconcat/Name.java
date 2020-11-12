package stringconcat;

public class Name {

    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        if(isEmpty(givenName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {
        if (isEmpty(familyName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        if(isEmpty(givenName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public String concatNameWesternStyle() {
        String fullName = "";
        if (title != null) {
            fullName += title.getTitle();
        }
        fullName += givenName + " ";
        if (!isEmpty(middleName)){
            fullName += middleName + " ";
        }
        fullName += familyName;
        return fullName;
    }

    public String concatNameHungarianStyle() {
        String fullName = "";
        if (title != null) {
            fullName = fullName.concat(title.getTitle());
        }
        fullName = fullName.concat(familyName);
        fullName = fullName.concat(" ");
        if (!isEmpty(middleName)){
            fullName = fullName.concat(middleName);
            fullName = fullName.concat(" ");
        }
        fullName = fullName.concat(givenName);
        return fullName;
    }

    public boolean isEmpty (String option){
        if(option == null || option.equals("")){
            return true;
        }
        return false;
    }
}
