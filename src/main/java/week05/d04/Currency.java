package week05.d04;

public enum Currency {

    HUF(1D,1/300D),USD(1/300D,1D);

    private double inHuf;
    private double inUsd;

    Currency(double inHuf, double inUsd) {
        this.inHuf = inHuf;
        this.inUsd = inUsd;
    }

    public double getInHuf() {
        return inHuf;
    }

    public double getInUsd() {
        return inUsd;
    }
}
