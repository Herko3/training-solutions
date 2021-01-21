package collectionsautoboxing;

import java.util.ArrayList;
import java.util.List;

public class IntegerOperations {

    public List<Integer> createList(int... numbers){
        List<Integer> l = new ArrayList<>();
        for(int i : numbers){
            l.add(i);
        }
        return l;
    }

    public int sumIntegerList(List<Integer> integerList){
        int sum = 0;
        for(Integer i : integerList){
            if(i != null){
                sum += i;
            }
        }
        return sum;
    }

    public int sumIntegerObjects(Integer... integers){
        int sum = 0;
        for(Integer i : integers){
            if(i != null){
                sum += i;
            }
        }
        return sum;
    }
}
