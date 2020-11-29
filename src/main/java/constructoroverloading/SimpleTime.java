package constructoroverloading;

public class SimpleTime {

    private int hours;
    private int minutes;

    public SimpleTime(int hours, int minutes) {
        this(hours);
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this.hours = hours;
    }

    public SimpleTime(SimpleTime simpleTime){
        this(simpleTime.getHours(),simpleTime.getMinutes());
    }

    public int difference(SimpleTime simpleTime){
        int inMin = simpleTime.getHours()*60+simpleTime.getMinutes();
        return (hours*60+minutes)-inMin;
    }


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return hours + ":" + minutes;
    }
}
