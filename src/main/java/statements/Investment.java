package statements;

public class Investment {
    private double cost;
    private int fund;
    private int interestRate;
    private boolean active = true;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days){
        return fund * interestRate / 100.0 * days / 365;
    }

    public double close(int days){
        double total = (getFund()+getYield(days));
        cost = total*0.3/100;
        double payout = active ? total-cost : 0;
        active = false;
        return payout;
    }

}
