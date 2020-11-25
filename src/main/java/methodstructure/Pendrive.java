package methodstructure;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public void risePrice(int percent){
        price += price * percent/100;
    }

    public int comparePricePerCapacity(Pendrive anotherPendrive){
        double original = ((double) price)/capacity;
        double newOne = ((double) anotherPendrive.getPrice())/ anotherPendrive.getCapacity();
        if(original>newOne){
            return 1;
        }
        if(original<newOne){
            return -1;
        }
        return 0;
    }

    public boolean cheaperThan(Pendrive another){
        if(price<another.getPrice()){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " " + capacity + " " + price;
    }
}
