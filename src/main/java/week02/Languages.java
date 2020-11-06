package week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
        List<String> nyelvek = new ArrayList<>();
        nyelvek = Arrays.asList("Java","Python","JavaScript");

        for (String item : nyelvek){
            if(item.length()>5){
                System.out.println(item);
            }
        }
    }

}
