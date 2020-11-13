package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {

public int countWithBalanceGreaterThan(List<BankAccount> bankAccount, int number){
    int counter = 0;
    for (BankAccount helper : bankAccount){
        if(helper.getBalance()>number){
            counter++;
        }
    }
    return counter;
}

}
