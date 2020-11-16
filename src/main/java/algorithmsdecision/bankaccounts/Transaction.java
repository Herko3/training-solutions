package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;

public class Transaction {

    private String accountNumber;
    private TransactionOperation transactionOperation;
    private int amount;
    private LocalDateTime dateOfTransaction;
    private TransactionStatus status;

    public Transaction(String accountNumber, TransactionOperation transactionOperation, int amount, LocalDateTime dateOfTransaction) {
        this.accountNumber = accountNumber;
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.dateOfTransaction = dateOfTransaction;
    }

    public boolean isCredit(){
        if(transactionOperation.equals(TransactionOperation.CREDIT)){
            return true;
        }
        return false;
    }

    public boolean isDebit(){
        if(transactionOperation.equals(TransactionOperation.DEBIT)){
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public TransactionOperation getTransactionOperation() {
        return transactionOperation;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDateOfTransaction() {
        return dateOfTransaction;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
