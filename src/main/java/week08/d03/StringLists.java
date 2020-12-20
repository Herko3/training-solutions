package week08.d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> shortestWords(List<String> words) {
        List<String> result = new ArrayList<>();
        int size = Integer.MAX_VALUE;
        for (String word : words) {
            int wordLength = word.length();
            if (wordLength < size) {
                size = wordLength;
            }
        }
        for(String word : words){
            if(word.length() == size){
                result.add(word);
            }
        }
        return result;
    }
}
