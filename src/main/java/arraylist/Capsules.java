package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Capsules {

    private List<String> color = new ArrayList<>();

    public void addLast(String plus) {
        color.add(plus);
    }

    public void addFirst(String plus) {
        color.add(0, plus);

    }

    public void removeFirst() {
        color.remove(0);
    }

    public void removeLast() {
        color.remove(color.size() - 1);
    }

    public List<String> getColor() {
        return color;
    }


    public static void main(String[] args) {
        Capsules test = new Capsules();

        test.addFirst("Kék");
        test.addLast("Piros");
        System.out.println(test.getColor());
        test.addLast("sárga");
        test.addFirst("zöld");
        System.out.println(test.getColor());
        test.removeFirst();
        System.out.println(test.getColor());
        test.removeLast();
        System.out.println(test.getColor());

//        Bonus

        List <String> a = test.getColor();
        System.out.println("A létrehozott új változó: "+ a);
        a.clear();
        System.out.println("Az új változó: " + a);
        System.out.println("Az eredeti lista: " + test.getColor());
    }
}
