package methodoverloading;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;


    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time) {
        this.hours = time.getHours();
        this.minutes = time.getMinutes();
        this.seconds = time.getSeconds();
    }


    public boolean isEqual(Time time) {
        if (hours == time.getHours() && minutes == time.getMinutes() && seconds == time.getSeconds()) {
            return true;
        }
        return false;
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        Time time = new Time(hours, minutes, seconds);
        return isEqual(time);
    }

    public boolean isEarlier(Time time) {
        if (hours < time.getHours()) {
            return true;
        }
        if (hours == time.getHours() && minutes < time.getMinutes()) {
            return true;
        }
        if (hours == time.getHours() && minutes == time.getMinutes() && seconds < time.getSeconds()) {
            return true;
        }
        return false;
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        Time time = new Time(hours, minutes, seconds);
        return isEarlier(time);
    }


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
