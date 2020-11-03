package week02;

import java.util.Scanner;

public class Phone {
    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

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
