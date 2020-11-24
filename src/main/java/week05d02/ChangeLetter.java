package week05d02;

import java.util.Arrays;
import java.util.List;

public class ChangeLetter {

    private static final List<String> VOWELS = Arrays.asList("a","e","i","o","u","á","é","í","ó","ö","ő","ú","ü","ű");

    public String changeVowels(String s){
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        for(String search : VOWELS ){
            while(sb.indexOf(search) != -1){
                int index = sb.indexOf(search);
                sb.replace(index,index+1,"*");
            }
        }
        return sb.toString();
    }
}
