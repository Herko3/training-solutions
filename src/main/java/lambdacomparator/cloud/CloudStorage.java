package lambdacomparator.cloud;

public class CloudStorage implements Comparable<CloudStorage> {

    private String provider;
    private int space;
    private double price;
    private PayPeriod period;

    public CloudStorage(String provider, int space, PayPeriod period, double price) {
        this.provider = provider;
        this.space = space;
        this.price = price;
        this.period = period;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    @Override
    public int compareTo(CloudStorage o) {
        double thisOne = period == null ? 0 : price * 12 / period.getLength() / space * 1000;
        double otherOne = o.period == null ? 0 : o.price * 12 / o.period.getLength() / o.space * 1000;
        return Double.compare(thisOne,otherOne);
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public double getPrice() {
        return price;
    }

    public PayPeriod getPeriod() {
        return period;
    }


}
