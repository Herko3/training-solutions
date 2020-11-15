package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersons ){
        Salesperson aboveTarget = null;
        for(Salesperson maxDiff : salespersons){
            if(aboveTarget == null || aboveTarget.getDifferenceFromTarget()<maxDiff.getDifferenceFromTarget()){
                aboveTarget = maxDiff;
            }

        }

        return aboveTarget;
    }

}
