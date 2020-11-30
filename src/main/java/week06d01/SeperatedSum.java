package week06d01;

import java.util.Scanner;

public class SeperatedSum {

    public SumResults sum(String s) {
        if (isEmpty(s)){
            throw new IllegalArgumentException("String must not be empty");
        }
        s = s.replace(",", ".");
        Scanner scanner = new Scanner(s).useDelimiter(";");
        double sumPos = 0;
        double sumNeg = 0;
        while (scanner.hasNext()) {
            try {
                double toAdd = Double.valueOf(scanner.next());

                if (toAdd > 0) {
                    sumPos += toAdd;
                } else {
                    sumNeg += toAdd;
                }
            }catch (NumberFormatException nfe){

            }
        }
        double factor = Math.pow(10,howLong(s));
        sumNeg = Math.round(sumNeg*factor)/factor;
        return new SumResults(sumPos,sumNeg);
    }

    private int howLong(String s) {
        s = s.replace("-","");
        int size = 0;
        Scanner scanner = new Scanner(s).useDelimiter(";");
        while (scanner.hasNext()) {
            int search = scanner.next().length();
            if(size<search){
                size = search;
            }
        }
        return size;
    }

    private boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }

}
