package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private List<String> title = new ArrayList<>();

    public void add(String plus){
        title.add(plus);
    }

    public List<String> findAllByPrefix(String prefix){
        List<String> match = new ArrayList<>();
        for (String search : title){
            if(search.startsWith(prefix)){
                match.add(search);
            }
        }
        return match;
    }

    public void removeByPrefix(String prefix) {
        List<String> delete = new ArrayList<>();
        for (String search : title) {
            if (search.startsWith(prefix)) {
//                title.remove(search); hiba
                delete.add(search);
            }
        }
       title.removeAll(delete);
    }

    public List<String> getTitle() {
        return title;
    }

    public static void main(String[] args) {
        Books test = new Books();

        test.add("Próba");
        test.add("Próba - 2");
        test.add("Próba - 3");
        test.add("Test");
        test.add("Test - 2");
        test.add("Test - 3");

        System.out.println(test.findAllByPrefix("Próba"));
//        System.out.println(test.removeByPrefix("Test")); rögtön törles
        System.out.println(test.getTitle());
        System.out.println("Test prefixes könyvek eltávolítása");
        test.removeByPrefix("Test");
        System.out.println(test.getTitle());


    }
}
