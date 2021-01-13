package week11.d03;

import java.util.HashSet;
import java.util.Set;

public class CharCounter {

    public int countChars(String[] chars) {
        Set<Character> first = new HashSet<>();
        for (int i = 0; i < chars[0].length(); i++) {
            first.add(chars[0].charAt(i));
        }

        for (int i = 1; i < chars.length; i++) {
            Set<Character> next = new HashSet<>();
            for (int j = 0; j < chars[i].length(); j++) {
                next.add(chars[i].charAt(j));
            }
            first.retainAll(next);
        }

        return first.size();
    }


}
