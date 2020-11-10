package typeconversion.whichtype;

import java.util.Scanner;

public class WhichTypeMain {
    public static void main(String[] args) {

        WhichType type = new WhichType();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adjon meg egy számot");
        String s = scanner.nextLine();
        System.out.println("Az adott szám még az alábbi típusokba férne bele:" + type.whichType(s));
    }
}
