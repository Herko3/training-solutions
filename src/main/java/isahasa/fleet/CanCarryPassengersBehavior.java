package isahasa.fleet;

public class CanCarryPassengersBehavior implements CanCarryPassengers {

    private int passengers;
    private final int maxPassengers;

    public CanCarryPassengersBehavior( int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public int loadPassenger(int passengers) {
        int canLoad = maxPassengers - this.passengers;
        if (canLoad >= passengers) {
            this.passengers += passengers;
            return 0;
        }
        this.passengers = maxPassengers;
        return passengers - canLoad;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }


}
