package datenewtypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    private LocalDate dateOfBirth;

    public DateOfBirth(String birth, String pattern, Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + pattern);
        }

        dateOfBirth = LocalDate.parse(birth, DateTimeFormatter.ofPattern(pattern, locale));
    }

    public DateOfBirth(String birth, String pattern) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + pattern);
        }
        dateOfBirth = LocalDate.parse(birth, DateTimeFormatter.ofPattern(pattern));
    }

    public DateOfBirth(int year, int month, int day) {
        dateOfBirth = LocalDate.of(year, month, day);
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return dateOfBirth.getDayOfWeek().getDisplayName(TextStyle.FULL,locale);
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate other) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return other.getDayOfWeek().getDisplayName(TextStyle.FULL,locale);
    }

    public long countDaysSinceBirth(LocalDate date) {
        if (dateOfBirth.isAfter(date)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        return ChronoUnit.DAYS.between(dateOfBirth, date);
    }

    public long countDaysBetween(DateOfBirth another) {
        return ChronoUnit.DAYS.between(dateOfBirth,another.getDateOfBirth());
    }

    public String toString(String pattern) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + pattern);
        }
        return dateOfBirth.format(DateTimeFormatter.ofPattern(pattern));
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
