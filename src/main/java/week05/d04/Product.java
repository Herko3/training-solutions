package week05.d04;

public class Product {

    private long price;
    private Currency currency;

    public Product(long price, Currency currency) {
        if(currency == null){
            throw new IllegalArgumentException("Currency can't be null");
        }
        this.price = price;
        this.currency = currency;
    }

    public double convertPrice(Currency convert){
        if(convert == null){
            throw new IllegalArgumentException("Currency can't be null");
        }

        if(currency.equals(Currency.HUF)) {
            return price * convert.getInHuf();
        }
        return price/convert.getInUsd();
    }
}
