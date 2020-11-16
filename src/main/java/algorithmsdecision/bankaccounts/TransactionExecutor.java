package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecutor {

    public void executeTransactions(List<Transaction> transactions, List<BankAccount> bankAccounts) {
        for (Transaction help : transactions) {
            if (help.isCredit()) {
                for (BankAccount account : bankAccounts) {
                    if (account.getAccountNumber().equals(help.getAccountNumber())) {
                        account.deposit(help.getAmount());
                        help.setStatus(TransactionStatus.SUCCEEDED);
                    }
                }
            }
            if (help.isDebit()) {
                for (BankAccount account : bankAccounts) {
                    if (account.getAccountNumber().equals(help.getAccountNumber())) {
                        if (account.withdraw(help.getAmount())) {
                            help.setStatus(TransactionStatus.SUCCEEDED);
                        } else {
                            help.setStatus(TransactionStatus.PENDING);
                        }
                    }
                }
            }
        }
    }
}