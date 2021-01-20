package collectionsmap;

import java.time.LocalDate;

public class Entry {

    private String IpAddress;
    private LocalDate EntryDate;
    private String Login;

    public Entry(String ipAddress, LocalDate entryDate, String login) {
        IpAddress = ipAddress;
        EntryDate = entryDate;
        Login = login;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public LocalDate getEntryDate() {
        return EntryDate;
    }

    public String getLogin() {
        return Login;
    }
}
