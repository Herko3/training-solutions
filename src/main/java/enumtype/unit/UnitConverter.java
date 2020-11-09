package enumtype.unit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {

    private final int SCALE = 4;

    public List<LengthUnit> siUnits(){
        List<LengthUnit> si = new ArrayList<>();
        for (LengthUnit ciklus : LengthUnit.values()){
            if(ciklus.isSi()){
                si.add(ciklus);
            }
        }
        return si;
    }

//    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target){
//        BigDecimal value = new BigDecimal();
//
//    }

    public double convert (double length,LengthUnit source, LengthUnit target){
        double factor = Math.pow(10,SCALE);
        double ertek = length * source.getToMm()/ target.getToMm();
        return Math.round(ertek*factor)/factor;
    }

}
