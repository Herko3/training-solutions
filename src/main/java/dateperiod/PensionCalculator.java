package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PensionCalculator {

    private final static int DAYS_OF_YEAR = 365;
    private final static int DAYS_OF_MONTH = 30;

    private List<Period> periods = new ArrayList<>();

    public void addEmploymentPeriod(Period toAdd) {
        periods.add(toAdd);
    }

    public Period sumEmploymentPeriods() {
        Period result = Period.ofDays(0);
        for (Period period : periods) {
            result = result.plus(period);
        }
        return fullyNormalized(result);
    }

    public int calculateTotalDays(Period period) {
        period = period.normalized();
        return period.getDays() + period.getMonths() * DAYS_OF_MONTH + period.getYears() * DAYS_OF_YEAR;
    }

    public Period modifyByDays(Period period, int days) {
        return fullyNormalized(period.plusDays(days));
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) {
            throw new NullPointerException("Null parameters are not allowed!");
        }

        return fullyNormalized(Period.between(fromDate, toDate));
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        if (pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + pattern);
        }
        if (fromDate.isBlank()) {
            throw new IllegalArgumentException("Empty from date string, cannot use: " + fromDate);
        }
        if (toDate.isBlank()) {
            throw new IllegalArgumentException("Empty to date string, cannot use: " + toDate);
        }

        LocalDate from = LocalDate.parse(fromDate, DateTimeFormatter.ofPattern(pattern));
        LocalDate to = LocalDate.parse(toDate, DateTimeFormatter.ofPattern(pattern));
        return fullyNormalized(Period.between(from, to));
    }

    public Period fullyNormalized(Period period) {
        long monthFromDay = period.getDays() / DAYS_OF_MONTH;
        return period.plusMonths(monthFromDay).minusDays(monthFromDay * DAYS_OF_MONTH).normalized();
    }

}
