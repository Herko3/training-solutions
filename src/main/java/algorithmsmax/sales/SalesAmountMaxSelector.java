package algorithmsmax.sales;

import java.util.ArrayList;
import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersons){
        Salesperson maxSales = null;
        for(Salesperson max : salespersons){
            if(maxSales == null || maxSales.getAmount()<max.getAmount()){
                maxSales = max;
            }

        }
        return maxSales;
    }
}
