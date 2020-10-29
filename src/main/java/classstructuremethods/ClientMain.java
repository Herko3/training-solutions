package classstructuremethods;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        client.setName("Jack");
        client.setYear(1980);
        client.setAddress("1152 Budapest, Fő utca 12");

        System.out.println("Név:" + client.getName());
        System.out.println("Születési év: " + client.getYear());
        System.out.println("Lakcím: " + client.getAddress());
        System.out.println("Cím módosítása az alábbi értékre:");

        Scanner scanner = new Scanner(System.in);
        client.migrate(scanner.nextLine());

        System.out.println("A módosított lakcím: " + client.getAddress());
    }


}
