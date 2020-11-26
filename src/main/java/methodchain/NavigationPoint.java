package methodchain;

public class NavigationPoint {

    private int distance;
    private int azimut;

    public NavigationPoint withMeter(int distance) {
        this.distance = distance;
        return this;
    }

    public NavigationPoint withAzimut(int azimut) {
        this.azimut = azimut;
        return this;
    }

    @Override
    public String toString() {
        return "distance: " + distance + " azimut: " + azimut;
    }
}
