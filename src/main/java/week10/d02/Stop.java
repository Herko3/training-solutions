package week10.d02;

public class Stop {

    private String id;
    private int numberOfPassengers;

    public Stop(String id) {
        this.id = id;
        numberOfPassengers = 1;
    }

    public void plusPassenger(){
        numberOfPassengers++;
    }

    public String getId() {
        return id;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
}
