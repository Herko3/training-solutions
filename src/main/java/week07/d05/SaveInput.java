package week07.d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            System.out.println("Adja meg az " + i + ". sort");
            lines.add(sc.nextLine());
        }
        System.out.println("Adja meg a file nevét");
        Path file = Path.of(sc.nextLine());
        try {
            Files.write(file,lines);
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot write file", exception);
        }
    }

}
