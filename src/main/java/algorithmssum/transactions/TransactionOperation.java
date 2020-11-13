package algorithmssum.transactions;

public enum TransactionOperation {

    CREDIT("Credit"),DEBIT("Debit");

    private final String name;

    TransactionOperation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
