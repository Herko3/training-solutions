package exampractice;

public class OfficeSoftware extends Software {

    public OfficeSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        price += price * 0.05;
    }
}
