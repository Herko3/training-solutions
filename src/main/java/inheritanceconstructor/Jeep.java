package inheritanceconstructor;

public class Jeep extends Car {

    private final double extraCapacity;
    private double extraFuel;


    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (extraFuel > extraCapacity) {
            throw new IllegalArgumentException("Extra capacity is less than extra fuel!");
        }
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public void modifyFuelAmount(double fuel) {
        fuel = -fuel;
        if (fuel <= extraFuel) {
            extraFuel -= fuel;
            return;
        }
        fuel -= extraFuel;
        extraFuel = 0;
        super.modifyFuelAmount(-fuel);
    }

    public void drive(int km) {
        double usedFuel = km / 100D * getFuelRate();
        isLess(usedFuel);
        modifyFuelAmount(-usedFuel);
    }

    public double calculateRefillAmount() {
        return super.calculateRefillAmount() + (extraCapacity - extraFuel);
    }

    private void isLess(double fuel) {
        if ((getFuel() + getExtraFuel()) < fuel) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
    }

    public double getExtraFuel() {
        return extraFuel;
    }
}
