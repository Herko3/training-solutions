package virtualmethod;

public class Car extends Vehicle{

    private int numberOfPassenger;

    public Car(int vehicleWeight, int numberOfPassengers) {
        super(vehicleWeight);
        this.numberOfPassenger = numberOfPassengers;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + numberOfPassenger * getPersonAverageWeight();
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfPassenger=" + numberOfPassenger +  ", vehicleWeight=" + getVehicleWeight() +
                '}';
    }

    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }
}
