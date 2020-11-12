package stringbasic;

public class StringCreator {

    public String createStringForHeap(){
        String heap = new String("John Doe");
        return heap;
    }
    public String createStringForPool(){
        String pool = "John Doe";
        return pool;
    }
}
