package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactions,int number){
        int counter = 0;
        for(Transaction help : transactions){
            if(help.getAmount()<number){
                counter++;
            }
        }
        return counter;
    }

}
