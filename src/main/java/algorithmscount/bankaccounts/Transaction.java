package algorithmscount.bankaccounts;

import algorithmssum.transactions.TransactionOperation;

public class Transaction {

    private String accountNumber;
    private TransactionType transactionType;
    private int amount;

    public Transaction(String accountNumber, TransactionType transactionType, int amount) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isCredit(){
        return transactionType.getName().equals("Credit");
    }

    public boolean isDebit(){
        return transactionType.getName().equals("Debit");
    }

}
