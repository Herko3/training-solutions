package isahasa.fleet;

public class CanCarryGoodsBehavior implements CanCarryGoods {

    private int cargoWeight;
    private final int maxCargoWeight;

    public CanCarryGoodsBehavior(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public int loadCargo(int weight) {
        int canLoad = maxCargoWeight - cargoWeight;
        if (canLoad >= weight) {
            cargoWeight += weight;
            return 0;
        }else {
         cargoWeight = maxCargoWeight;
        }
        return weight - canLoad;
    }

    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }

    public int getMaxCargoWeight() {
        return maxCargoWeight;
    }
}
