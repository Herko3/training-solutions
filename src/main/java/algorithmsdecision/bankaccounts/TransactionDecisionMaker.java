package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {

    public boolean containsCreditEntryGreaterThan(List<Transaction> transactions, LocalDateTime startTime, LocalDateTime endTime, int amount) {
        for (Transaction help : transactions) {
            if (help.isDebit() && help.getDateOfTransaction().isAfter(startTime)
                    && help.getDateOfTransaction().isBefore(endTime) && help.getAmount() > amount) {

                return true;
            }
        }
        return false;
    }

}
