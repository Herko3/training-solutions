package exampractice;

public class DeveloperSoftware extends Software {

    public DeveloperSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        price += price * 0.1;
    }
}
