package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Rendezvous {

    LocalTime rendezvou;

    public Rendezvous(String time, String pattern) {
        if (pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
        if (time.isBlank()) {
            throw new IllegalArgumentException("Illegal time string: " + time);
        }
        try {
            rendezvou = LocalTime.parse(time, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Illegal time string: " + time, e);
        }
    }

    public Rendezvous(int hour, int minute) {
        rendezvou = LocalTime.of(hour, minute);
    }

    public String toString(String pattern) {
        if (pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
        return rendezvou.format(DateTimeFormatter.ofPattern(pattern));
    }

    public long countMinutesLeft(LocalTime time) {
        long left = ChronoUnit.MINUTES.between(time, rendezvou);
        if (left < 0) {
            throw new MissedOpportunityException("Too late!");
        }
        return left;
    }

    public void pushLater(int hour, int minute) {
        rendezvou = rendezvou.plusHours(hour).plusMinutes(minute);
    }

    public void pullEarlier(int hour, int minute) {
        rendezvou = rendezvou.minusHours(hour).minusMinutes(minute);
    }

}
