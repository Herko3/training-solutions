package week15.d01;

import java.util.List;

public class BitcoinBuy {

    public BestRate calculator(List<Integer> rates) {
        int diff = Integer.MIN_VALUE;
        BestRate br = null;
        for (int i = 0; i < rates.size(); i++) {
            for (int j = i + 1; j < rates.size(); j++) {
                int actualDiff = rates.get(j) - rates.get(i);
                if (actualDiff > diff) {
                    br = new BestRate(i+1,j+1,actualDiff);
                    diff = actualDiff;
                }
            }
        }
        return br;
    }

}
