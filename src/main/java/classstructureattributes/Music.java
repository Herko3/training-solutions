package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Song song = new Song ();
        System.out.println("Adja meg a kedvenc bandáját!");
        song.band = scanner.nextLine();
        System.out.println("Adja meg tőlük a kedvenc számát");
        song.title = scanner.nextLine();
        System.out.println("Adja meg a szám hosszát percben");
        song.length = scanner.nextInt();
        scanner.nextLine();

        System.out.println("A megadott szám:");
        System.out.println(song.band + " - " + song.title + " (" + song.length + " perc)");

    }
}
