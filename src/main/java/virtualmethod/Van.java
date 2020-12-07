package virtualmethod;

public class Van extends Car{

    private int cargoWeight;

    public Van(int vehicleWeight, int numberOfPassengers, int cargoWeight) {
        super(vehicleWeight, numberOfPassengers);
        this.cargoWeight = cargoWeight;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + cargoWeight;
    }

    @Override
    public String toString() {
        return "Van{" +
                "cargoWeight=" + cargoWeight + ", numberOfPassenger=" + getNumberOfPassenger() +  ", vehicleWeight=" + getVehicleWeight() +
                '}';
    }
}
