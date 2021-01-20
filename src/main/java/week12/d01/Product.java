package week12.d01;

public class Product implements Comparable<Product> {

    private int weight;
    private int price;
    private double rate;

    public Product(int weight, int price) {
        this.weight = weight;
        this.price = price;
        rate = price / weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public int compareTo(Product o) {
        return (int) (o.rate - rate);
    }
}
