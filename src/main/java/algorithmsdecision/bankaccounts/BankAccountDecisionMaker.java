package algorithmsdecision.bankaccounts;

import classstructureintegrate.Bank;

import java.util.List;

public class BankAccountDecisionMaker {

    public boolean containsBalanceGreaterThan(List<BankAccount> account, int lower ){
        for(BankAccount help : account){
            if(help.getBalance()>lower){
                return true;
            }
        }
        return false;
    }

}
