package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount {

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overDraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overDraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        long needed = amount + costOfTransaction(amount);
        if ((getBalance() + overdraftLimit) > needed) {
            setBalance(getBalance() - needed);
            if (getBalance() < 0) {
                overdraftLimit += getBalance();
                balanceToZero();
            }
            return true;
        }
        return false;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }
}
