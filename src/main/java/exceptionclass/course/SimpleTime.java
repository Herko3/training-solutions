package exceptionclass.course;

public class SimpleTime {

    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        timeValidator(hour, minute);
        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String time) {
        if (time == null) {
            throw new InvalidTimeException("Time is null");
        }
        String[] timeParts = time.split(":");
        try {
            hour = Integer.parseInt(timeParts[0]);
            minute = Integer.parseInt(timeParts[1]);
            timeValidator(hour, minute);
        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    private void timeValidator(int hour, int minute){
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
    }
}
