package dateoldtypes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateOfBirth {

    private Date dateOfBirth;

    public DateOfBirth(int year, int month, int day) {
        Calendar c = new GregorianCalendar(year, month - 1, day);
        c.setLenient(false);
        dateOfBirth = c.getTime();
    }

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        validateDateString(dateString);
        validatePattern(pattern);
        validateLocale(locale);

        DateFormat format = new SimpleDateFormat(pattern, locale);
        try {
            dateOfBirth = format.parse(dateString);
        } catch (ParseException pe) {
            throw new IllegalStateException("Cannot parse");
        }
    }

    public DateOfBirth(String dateString, String pattern) {
        validateDateString(dateString);
        validatePattern(pattern);

        DateFormat format = new SimpleDateFormat(pattern);
        try {
            dateOfBirth = format.parse(dateString);
        } catch (ParseException pe) {
            throw new IllegalStateException("Cannot parse");
        }
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        validateLocale(locale);

        return new SimpleDateFormat("EEEE", locale).format(dateOfBirth);
    }

    public String toString(String pattern) {
        validatePattern(pattern);

        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(dateOfBirth);
    }

    public boolean isWeekDay() {
        Calendar c = Calendar.getInstance();
        c.setTime(dateOfBirth);
        return c.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && c.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY;
    }

    private void validateDateString(String dateString) {
        if (dateString == null || dateString.isBlank()) {
            throw new IllegalArgumentException("Illegal date string, cannot parse: " + dateString);
        }

    }

    private void validatePattern(String pattern) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + pattern);
        }
    }

    private void validateLocale(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
    }

}
