package algorithmssum.transactions;

import java.util.List;

public class TransactionSumCalculator {

    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sum = 0;
        for (Transaction helper : transactions) {
            if (helper.isCredit()) {
                sum += helper.getAmount();
            }
        }
        return sum;
    }
}
