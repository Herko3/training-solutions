package statements;

import java.util.Scanner;

public class TimeMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg hány óra van!");
        int hour =scanner.nextInt();
        scanner.nextLine();
        System.out.println("Adja meg hány perc van!");
        int min =scanner.nextInt();
        scanner.nextLine();
        System.out.println("Adja meg hány másdoperc van!");
        int sec= scanner.nextInt();
        scanner.nextLine();

        Time elso = new Time(hour,min,sec);

                System.out.println("Adja meg egy másik időpont óra számát!");
        hour =scanner.nextInt();
        scanner.nextLine();
        System.out.println("Adja meg egy másik időpont perc számát!!");
        min =scanner.nextInt();
        scanner.nextLine();
        System.out.println("Adja meg egy másik időpont másdoperc számát!!");
        sec= scanner.nextInt();
        scanner.nextLine();

        Time masodik = new Time(hour,min,sec);

        System.out.println("Az első időpont: " + elso.toString() + " = " + elso.getInMinutes() + " perc");
        System.out.println("A második időpont: " + masodik.toString() + " = " + masodik.getInSeconds() + " másodperc");
        System.out.println("Az első időpont korábbi mint a második: " + elso.earlierThan(masodik));


    }
}
