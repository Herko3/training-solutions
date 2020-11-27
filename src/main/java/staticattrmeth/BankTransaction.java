package staticattrmeth;

import java.math.BigDecimal;

public class BankTransaction {

    private static final long MINTRX = 1L;
    private static final long MAXTRX = 10_000_000L;

    public static long currentMinValue;
    public static long currentMaxValue;
    public static BigDecimal sumOfTrxs;
    public static int numberOfTransactions;

    private long trxValue;

    public static void initTheDay() {
        currentMaxValue = 0;
        currentMinValue = 0;
        sumOfTrxs = new BigDecimal(0);
        numberOfTransactions = 0;
    }

    public BankTransaction(long trxValue) {
        if (trxValue < MINTRX || trxValue > MAXTRX){
            throw new IllegalArgumentException("Transaction value must be between 1 and 10 000 000");
        }
            this.trxValue = trxValue;
        sumOfTrxs = sumOfTrxs.add(new BigDecimal(trxValue));
        if (currentMaxValue == 0 || trxValue > currentMaxValue) {
            currentMaxValue = trxValue;
        }
        if (currentMinValue == 0 || trxValue < currentMinValue) {
            currentMinValue = trxValue;
        }
        numberOfTransactions++;
    }

    public static BigDecimal averageOfTransaction() {
        if (numberOfTransactions == 0) {
            return new BigDecimal(0);
        }
        return sumOfTrxs.divide(new BigDecimal(numberOfTransactions));
    }

    public static long getCurrentMinValue() {
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        return sumOfTrxs;
    }

    public long getTrxValue() {
        return trxValue;
    }
}
