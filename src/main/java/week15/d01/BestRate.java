package week15.d01;

public class BestRate {

    private int buyDay;
    private int sellDay;
    private int diff;

    public BestRate(int buyDay, int sellDay, int diff) {
        this.buyDay = buyDay;
        this.sellDay = sellDay;
        this.diff = diff;
    }

    public int getBuyDay() {
        return buyDay;
    }

    public int getSellDay() {
        return sellDay;
    }

    public int getDiff() {
        return diff;
    }
}
