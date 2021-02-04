package datenewtypes;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

public class FamilyBirthdays {

    List<LocalDate> familyBirthdays = new ArrayList<>();

    public FamilyBirthdays(LocalDate... dates) {
        for(LocalDate date : dates){
            familyBirthdays.add(date);
        }
    }

    public boolean isFamilyBirthday(TemporalAccessor date){
        int day = date.get(ChronoField.DAY_OF_MONTH);
        int month = date.get(ChronoField.MONTH_OF_YEAR);

        for (LocalDate birthday : familyBirthdays) {
            if (birthday.getMonthValue() == month && day == birthday.getDayOfMonth()) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date){
        int year = date.get(ChronoField.YEAR);
        LocalDate baseDate = LocalDate.of(year, date.get(ChronoField.MONTH_OF_YEAR), date.get(ChronoField.DAY_OF_MONTH));

        int next = Integer.MAX_VALUE;

        for (LocalDate birthday : familyBirthdays) {
            LocalDate nextBirthday = birthday.withYear(year);
            if (nextBirthday.isBefore(baseDate)) {
                nextBirthday = birthday.withYear(year + 1);
            }

            int dayNumber = (int) ChronoUnit.DAYS.between(baseDate, nextBirthday);
            if (dayNumber < next) {
                next = dayNumber;
            }
        }

        return next;
    }
}
