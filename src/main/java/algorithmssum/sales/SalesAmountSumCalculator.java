package algorithmssum.sales;

import java.util.ArrayList;
import java.util.List;

public class SalesAmountSumCalculator {

    public int sumSalesAmount(List<Salesperson> salesperson){

        int sum = 0;
        for(Salesperson person : salesperson){
            sum+= person.getAmount();
        }

        return sum;
    }

}
