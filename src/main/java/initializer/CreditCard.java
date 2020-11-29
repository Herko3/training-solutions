package initializer;

public class CreditCard {

    public static final Rate[] RATES;

    private long balance;

    static {
        Rate[] rates = {new Rate(Currency.HUF, 1.0),
                new Rate(Currency.EUR, 308.23),
                new Rate(Currency.SFR, 289.24),
                new Rate(Currency.GBP, 362.23),
                new Rate(Currency.USD, 289.77)};
        RATES = rates;
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public CreditCard(long balance, Currency currency) {

        this.balance = (long) (balance * rateFactor(currency));
    }

    public boolean payment(long amount, Currency currency) {
        long amountInHuf = (long) (amount * rateFactor(currency));
        return payment(amountInHuf);
    }

    public boolean payment(long amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public long getBalance() {
        return balance;
    }

    private double rateFactor(Currency currency) {
        double conversionFactor = 0;
        for (Rate rate : RATES) {
            if (rate.getCurrency().equals(currency)) {
                conversionFactor = rate.getConversionFactor();
            }
        }
        return conversionFactor;
    }

}
