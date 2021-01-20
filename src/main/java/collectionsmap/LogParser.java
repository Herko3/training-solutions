package collectionsmap;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

    public static final int SIZE_OF_LOG = 3;
    public static final String SEPARATOR = ":";
    public static final int INDEX_OF_IP = 0;
    public static final int INDEX_OF_DATE = 1;
    public static final int INDEX_OF_LOGIN = 2;
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Map<String, List<Entry>> entries = new HashMap<>();

    public Map<String, List<Entry>> parseLog(String log) {

        try (Scanner sc = new Scanner(log)) {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] parts = line.split(SEPARATOR);
                validateLine(parts);
                LocalDate entryDate = createDate(parts[INDEX_OF_DATE]);
                addEntry(new Entry(parts[INDEX_OF_IP], entryDate, parts[INDEX_OF_LOGIN]));
            }
        }

        return entries;
    }

    private void validateLine(String[] parts) {
        if (parts.length != SIZE_OF_LOG) {
            throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
        }
    }

    private LocalDate createDate(String date) {
        try {
            return LocalDate.parse(date, DATE_FORMAT);
        } catch (DateTimeParseException parseException) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
    }

    private void addEntry(Entry entry) {
        if (!entries.containsKey(entry.getIpAddress())) {
            entries.put(entry.getIpAddress(), new ArrayList<>());
        }
        entries.get(entry.getIpAddress()).add(entry);
    }
}
