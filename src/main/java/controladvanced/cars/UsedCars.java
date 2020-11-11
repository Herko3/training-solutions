package controladvanced.cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsedCars {

    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length != 4) {
                continue;
            }
            if (parts[0].length() != 7){
                continue;
            }
            if (!parts[0].contains("-")){
                continue;
            }
            if(Integer.parseInt(parts[1])>2019 || Integer.parseInt(parts[1])<=1970){
                continue;
            }
            validLines.add(line);
        }
        return validLines;
    }

    public static void main(String[] args) {
        UsedCars test = new UsedCars();
        List<String> sorok = new ArrayList<>();
        sorok.add("ABC-123;1999;Volvo;red");
        sorok.add("ABC-124;2000;Volvo;red");
        sorok.add("ABC5124;2000;Volvo;red");
        sorok.add("AB124;2000;Volvo;red");
        sorok.add("ABC-124;2019;Volvo;red");
        sorok.add("ABC-124;2018;Volvo;red");
        sorok.add("ABC-124;1970;Volvo;red");
        sorok.add("ABC-124;1969;Volvo;red");
        sorok.add("ABC-124;1971;Volvo;red");
        System.out.println(sorok);
        System.out.println(test.filterLines(sorok));
    }

}
