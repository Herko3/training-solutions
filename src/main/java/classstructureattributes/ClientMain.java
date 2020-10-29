package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Client client = new Client ();
        System.out.println("Adja meg a nevét!");
        client.name = scanner.nextLine();
        System.out.println("Adja meg a születési évét!");
        client.year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Adja meg a címét!");
        client.address = scanner.nextLine();

        System.out.println("Név: " + client.name);
        System.out.println("Születési év: " + client.year);
        System.out.println("Lakcím: " + client.address);

    }
}
