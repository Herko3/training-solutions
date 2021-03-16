package exampractice;

public abstract class Software {

    private String name;
    protected double price;

    public Software(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public abstract void increasePrice();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
