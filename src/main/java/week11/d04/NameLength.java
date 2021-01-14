package week11.d04;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NameLength {

    public List<Integer> getLengths(List<String> names) {
        if(names == null || names.isEmpty()){
            throw new IllegalArgumentException("Names list must not be null nor empty");
        }

        Set<Integer> result = new TreeSet<>();
        for (String name : names) {
            if(name != null && name.toUpperCase().startsWith("J")){
                result.add(name.length());
            }
        }
        return new ArrayList<>(result);
    }

}
