package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersons ){
        Salesperson aboveTarget = null;
        for(Salesperson maxDiff : salespersons){
            if(aboveTarget == null || aboveTarget.getDifferenceFromTarget()>maxDiff.getDifferenceFromTarget()){
                aboveTarget = maxDiff;
            }

        }

        return aboveTarget;
    }


}
