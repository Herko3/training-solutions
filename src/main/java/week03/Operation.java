package week03;

import java.util.Scanner;

public class Operation {

    private int leftValue;
    private int rightValue;

    public Operation(String s) {
        if(!s.contains("+")){
            throw new IllegalArgumentException("Nem megfelelő megadás");
        }

        leftValue = Integer.parseInt(s.substring(0,s.indexOf("+")).trim());
        rightValue = Integer.parseInt(s.substring(s.indexOf("+")+1).trim());
    }
    public int getResult(){
        return leftValue+rightValue;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adjon meg egy összeadást, x+y formában");
        Operation operation = new Operation(scanner.nextLine());
    }
}
