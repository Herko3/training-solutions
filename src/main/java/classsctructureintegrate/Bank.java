package classsctructureintegrate;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Számla tulajdonos neve:");
        String owner = scanner.nextLine();
        System.out.println("Számlaszáma:");
        String accountNumber = scanner.nextLine();
        System.out.println("Kezdő egyenleg");
        int balance =scanner.nextInt();
        scanner.nextLine();

        BankAccount account1 = new BankAccount(accountNumber,owner,balance);

        System.out.println("Számla tulajdonos neve:");
        owner = scanner.nextLine();
        System.out.println("Számlaszáma:");
        accountNumber = scanner.nextLine();
        System.out.println("Kezdő egyenleg");
        balance =scanner.nextInt();
        scanner.nextLine();

        BankAccount account2 = new BankAccount(accountNumber,owner,balance);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

        System.out.println("Első számlára befizetés összege");
        account1.deposit(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Második számlára befizetés összege");
        account2.deposit(scanner.nextInt());
        scanner.nextLine();

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

        System.out.println("Első számláról kivétel összege");
        account1.withdraw(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Második számláról kivétel összege");
        account2.withdraw(scanner.nextInt());
        scanner.nextLine();

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

        System.out.println("Átutalás összege a 2. számlára");
        account1.transfer(account2, scanner.nextInt());
        scanner.nextLine();
        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

        System.out.println("Átutalás összege az 1. számlára");
        account2.transfer(account1, scanner.nextInt());
        scanner.nextLine();
        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

    }
}
