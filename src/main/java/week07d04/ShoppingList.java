package week07d04;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {

    public long calculateSum(String path) {
        long sum = 0;
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(Path.of(path))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
        for (String line : lines){
            String[] actual = line.split(";");
            validateLine(actual);
            sum += Long.parseLong(actual[1]) * Long.parseLong(actual[2]);
        }
            return sum;
    }

    private void validateLine(String[] line){
        if(line.length != 3){
            throw new IllegalArgumentException("Line is not valid");
        }
        try{
            Long.parseLong(line[1]);
            Long.parseLong(line[2]);
        } catch (NumberFormatException nfe){
            throw new IllegalArgumentException("Quantity or price is not a number");
        }

    }

}
