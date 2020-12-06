package interfacedefaultmethods;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable {

    private List<String> contents = new ArrayList<>();

    @Override
    public int getLength() {
        return contents.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return contents.get(pageNumber);
    }

    public void addPage(String s){
        contents.add(s);
    }
}
