package datedaylight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FlightInfo {

    ZonedDateTime time;

    public FlightInfo(String dateString, String pattern, Locale locale, ZoneId zone){
        if(dateString == null || dateString.isBlank()){
            throw new IllegalArgumentException("Empty date string parameter!");
        }
        if(pattern == null || pattern.isBlank()){
            throw new IllegalArgumentException("Empty pattern string parameter!");
        }
        if(locale == null){
            throw new NullPointerException("Locale must not be null!");
        }

        LocalDateTime localDateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern, locale));
        time = ZonedDateTime.of(localDateTime,zone);
    }

    public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes){
        ZonedDateTime arrival = time.plusHours(flightHours).plusMinutes(flightMinutes);
        return arrival.withZoneSameInstant(zone);
    }

    public ZonedDateTime getDepartureDateTime(){
        return time;
    }

}
