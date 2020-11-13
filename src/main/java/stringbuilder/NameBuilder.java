package stringbuilder;

import javax.management.monitor.StringMonitorMBean;

public class NameBuilder {

    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder hungarian = new StringBuilder();
        if (title != null) {
            hungarian.append(title.getTitle() + " ");
        }
        hungarian.append(familyName + " ");
        if(!isEmpty(middleName)){
            hungarian.append(middleName + " ");
        }
        hungarian.append(givenName);
        return hungarian.toString();
    }

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder western = new StringBuilder();
        if (title != null) {
            western.append(title.getTitle() + " ");
        }
        western.append(givenName + " ");
        if(!isEmpty(middleName)){
            western.append(middleName + " ");
        }
        western.append(familyName);
        return western.toString();
    }

    public String insertTitle(String name, Title title, String s) {
        StringBuilder more = new StringBuilder(name);
        if (name.contains(".")){
            more.insert(more.indexOf(".")+2, title.getTitle() + s);
        } else {
            more.insert(0, title.getTitle() + s);
        }
        return more.toString();
    }

    public String deleteNamePart(String name, String delete) {
        StringBuilder deleted = new StringBuilder(name);
        deleted.delete(deleted.indexOf(delete), deleted.indexOf(delete) + delete.length());
        return deleted.toString();
    }

    public boolean isEmpty(String option) {
        if (option == null || option.equals("")) {
            return true;
        }
        return false;
    }

}
