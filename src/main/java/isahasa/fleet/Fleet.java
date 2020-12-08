package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Ship> ships = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;

    public void addShip(Ship ship){
        if(ship == null){
            throw new IllegalArgumentException("Ship cannot be null");
        }
        ships.add(ship);
    }

    public void loadShip(int persons, int cargo){
        waitingPersons = persons;
        waitingCargo = cargo;
        for(Ship ship: ships){
            if(ship instanceof CanCarryPassengers){
                waitingPersons = ((CanCarryPassengers) ship).loadPassenger(waitingPersons);
            }
            if (ship instanceof CanCarryGoods){
                waitingCargo = ((CanCarryGoods) ship).loadCargo(waitingCargo);
            }
        }

    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}
