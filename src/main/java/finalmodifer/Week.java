package finalmodifer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week {

    private static final List<String> DAYS = Arrays.asList("hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap");

    public static void main(String[] args) {
        DAYS.set(1,"szerda");
        System.out.println(DAYS);
//        a konstans értékét is meg tudtam változtatni
    }

}
