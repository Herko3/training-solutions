package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {

    public List<Type> whichType(String s) {
        List<Type> befer = new ArrayList<>();
        long kiertekel = Long.parseLong(s);
        for(Type test : Type.values())
            if(kiertekel>test.getMin()){
                if (kiertekel<test.getMax()){
                    befer.add(test);
                }
            }
            return befer;
    }
}
