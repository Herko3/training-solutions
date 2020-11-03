package statements;

import java.util.Scanner;

public class InvestMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adja meg a befektetési összeget:");
        int fund = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Adja meg a kamatlábat");
        int interestRate = scanner.nextInt();
        scanner.nextLine();

        Investment invest = new Investment(fund,interestRate);
        System.out.println("Tőke:" + invest.getFund());
        System.out.println("Hány napra akarja ellenőrizni a hozamot?");
        int days = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Hozam " + days + " napra: " + invest.getYield(days));

        System.out.println("Hány nap után akarja lezárni?");
        days = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Kivett összeg " + days + " nap után:" + invest.close(days));
        System.out.println("Hány nap után akarja lezárni ismét?");
        days = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Kivett összeg " + days + " nap után:" + invest.close(days));

    }

}
