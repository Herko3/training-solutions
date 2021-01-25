package week11.d02;

public class Ride {

    private int day;
    private int rideNumber;
    private int distance;

    public Ride(int day, int rideNumber, int distance) {
        this.day = day;
        this.rideNumber = rideNumber;
        this.distance = distance;
    }

    public int getDay() {
        return day;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public int getDistance() {
        return distance;
    }
}
