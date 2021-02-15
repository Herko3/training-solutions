package week16.d01;

public enum CanoeType {
    RED(1),GREEN(1.2),BLUE(1.5);

    private double baseRate;

    CanoeType(double baseRate) {
        this.baseRate = baseRate;
    }

    public double getBaseRate() {
        return baseRate;
    }
}
