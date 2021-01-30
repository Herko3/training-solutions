package lambdaintro;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {

    private List<BankAccount> accounts;

    public BankAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        accounts.sort(Comparator.comparing(BankAccount::getAccountNumber));
        return accounts;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        Comparator<BankAccount> comp = (account1, account2) -> (int) (Math.abs(account1.getBalance()) - Math.abs(account2.getBalance()));
        accounts.sort(comp);
        return accounts;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        accounts.sort(Comparator.comparing(BankAccount::getBalance).reversed());
        return accounts;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {

        Collator collator = Collator.getInstance(new Locale("hu","HU"));
        Comparator<BankAccount> comp =
                Comparator.comparing(BankAccount::getNameOfOwner,Comparator.nullsFirst(collator))
                .thenComparing(BankAccount::getAccountNumber);
        accounts.sort(comp);
        return accounts;
    }

}
