package dateduration;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class WorkHoursCalculator {

    private final static int HOURS_OF_DAY = 24;

    private List<Duration> durations = new ArrayList<>();

    public void addWorkTime(Duration duration) {
        durations.add(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        durations.add(Duration.ofHours(days * HOURS_OF_DAY + hours).plusMinutes(minutes));
    }

    public void addWorkTime(String durationString) {
        if (durationString == null || durationString.isBlank()) {
            throw new IllegalArgumentException("Parameter must not be empty!");
        }
        try {
            durations.add(Duration.parse(durationString));
        } catch (DateTimeParseException e){
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found: " + durationString);
        }
    }

    public long calculateWorkHours() {
        Duration result = getDuration();
        return result.toHours();
    }

    public Duration getWorkDuration() {
        Duration result = getDuration();
        return result;
    }


    public String toString(){
        Duration result = getDuration();
        long days = result.toDays();
        int hours = result.toHoursPart();
        int minutes = result.toMinutesPart();

        return String.format("Days: %d, hours: %d, minutes: %d",days,hours,minutes);
    }

    private Duration getDuration() {
        Duration result = Duration.ZERO;
        for (Duration duration : durations) {
            result = result.plus(duration);
        }
        return result;
    }
}
