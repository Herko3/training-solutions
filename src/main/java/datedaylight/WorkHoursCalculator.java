package datedaylight;

import java.time.*;

public class WorkHoursCalculator {

    ZonedDateTime startDateTime;

    public WorkHoursCalculator(int startYear, Month startMonth, int startDay, int startHour, ZoneId zone){
        LocalDateTime time = LocalDateTime.of(startYear,startMonth,startDay,startHour,0);
        startDateTime = ZonedDateTime.of(time,zone);
    }

    public long calculateHours(int year, Month month, int day, int hour){
        ZonedDateTime endTime = ZonedDateTime.of(LocalDateTime.of(year,month,day,hour,0),startDateTime.getZone());
        return Duration.between(startDateTime,endTime).toHours();
    }

    public ZonedDateTime getStartDateTime() {
        return startDateTime;
    }
}
