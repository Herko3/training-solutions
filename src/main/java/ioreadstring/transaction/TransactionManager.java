package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<BankAccount> accountList = new ArrayList<>();

    public void uploadListFromFile(String path){

        try{
            List<String> lines = Files.readAllLines(Path.of(path));
            for(String line : lines){
                String[] parts = line.split(";");
                String name = parts[0];
                String accountNumber = parts[1];
                int balance = Integer.parseInt(parts[2]);
                accountList.add(new BankAccount(name,accountNumber,balance));
            }

        } catch (IOException ioe){
            throw new IllegalStateException("Cannot read file", ioe);
        } catch (NumberFormatException nfe){
            throw new IllegalArgumentException("Balance is not a number!", nfe);
        }
    }

    public void makeTransactions(String path){
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            for(String line : lines) {
                String[] parts = line.split(";");
                transaction(parts);
            }
        } catch(IOException ioe){
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    public List<BankAccount> getAccountList() {
        return accountList;
    }

    private void transaction(String[] transaction){
        for(BankAccount account : accountList){
            if(account.getAccountNumber().equals(transaction[0])){
                try{
                    account.setBalance(Integer.parseInt(transaction[1]));
                } catch (NumberFormatException nfe){
                    throw new IllegalArgumentException("Transaction value is not a number", nfe);
                }
            }
        }
    }
}
