package algorithmsdecision.bankaccounts;

public enum TransactionOperation {

    DEBIT("Debit"),CREDIT("Credit");

    private final String name;

    TransactionOperation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
