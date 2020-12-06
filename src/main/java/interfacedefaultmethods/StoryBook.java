package interfacedefaultmethods;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable{

    private List<ColoredPage> pages = new ArrayList<>();

    @Override
    public int getLength() {
        return pages.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return pages.get(pageNumber).getContent();
    }

    @Override
    public String getColor(int pageNumber) {
        return pages.get(pageNumber).getColor();
    }

    public void addPage(String content, String color){
        pages.add(new ColoredPage(content,color));
    }
}
