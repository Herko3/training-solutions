package isahasa.fleet;

public class Liner implements Ship,CanCarryPassengers {

    private CanCarryPassengers canCarryPassengers;

    public Liner(int maxPassenger) {
        canCarryPassengers = new CanCarryPassengersBehavior(maxPassenger);
    }

    @Override
    public int loadPassenger(int passengers) {
        return canCarryPassengers.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
}
