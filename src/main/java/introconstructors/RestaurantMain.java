package introconstructors;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMain {

    public static void main(String[] args) {
        Restaurant test = new Restaurant("Badwolf", 12);
        List<String> menu = new ArrayList<>();

        menu.add("Krumplipüré");
        menu.add("CSirke ragu leves");
        menu.add("Saláta");
        test.setMenu(menu);

        System.out.println(test.getName());
        System.out.println(test.getCapacity());
        System.out.println(test.getMenu());


    }
}
