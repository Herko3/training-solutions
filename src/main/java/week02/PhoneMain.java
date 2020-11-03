package week02;

import java.util.Scanner;

public class PhoneMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adjon meg egy telefon típust");
        String type = scanner.nextLine();
        System.out.println("Adja meg a hozzá tartozó memóriát");
        int mem = scanner.nextInt();
        scanner.nextLine();

        Phone phone1 = new Phone(type,mem);

        System.out.println("Adjon meg  másik telefon típust");
        type = scanner.nextLine();
        System.out.println("Adja meg a hozzá tartozó memóriát");
        mem = scanner.nextInt();
        scanner.nextLine();
        Phone phone2 = new Phone(type,mem);

        System.out.println("Az első telefon adatai:");
        System.out.println("Telefon típusa: " + phone1.getType() + " hozzá tartozó memória: " + phone1.getMem());
        System.out.println("A második telefon adatai:");
        System.out.println("Telefon típusa: " + phone2.getType() + " hozzá tartozó memória: " + phone2.getMem());
    }
}
