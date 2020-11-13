package algorithmscount.bankaccounts;

public enum TransactionType {
    CREDIT("Credit"),DEBIT("Debit");

    private final String name;

    TransactionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
