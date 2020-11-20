package week04;

import java.util.ArrayList;
import java.util.List;

public class Indexes {

    public List<Integer> getIndexesOfChar(String str, char c) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==c){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
    Indexes test = new Indexes();
        System.out.println(test.getIndexesOfChar("kefe",'e'));
        System.out.println(test.getIndexesOfChar("ketchup", 'e'));
    }


}
