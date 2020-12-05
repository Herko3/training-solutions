package inheritanceconstructor;

public class Car {

    private final double fuelRate;
    private double fuel;
    private final double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if(fuel>tankCapacity){
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel -= Math.abs(fuel);
    }

    public void drive(int km) {
        double usedFuel = km / 100D * fuelRate;
        isLess(usedFuel);
        modifyFuelAmount(usedFuel);
    }

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }

    private void isLess(double fuel) {
        if (this.fuel < fuel) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }
}
