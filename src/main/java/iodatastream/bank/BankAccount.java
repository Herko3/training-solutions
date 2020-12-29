package iodatastream.bank;

public class BankAccount {

    private String account;
    private String owner;
    private double balance;

    public BankAccount(String account, String owner, double balance) {
        this.account = account;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }
}
