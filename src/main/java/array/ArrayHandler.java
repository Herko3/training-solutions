package array;

public class ArrayHandler {

    public boolean contains(int[] source, int itemToFind) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == itemToFind) {
                return true;
            }
        }
        return false;
    }

    public int find(int[] source, int itemToFind){
        for (int i = 0; i < source.length; i++) {
            if (source[i] == itemToFind) {
                return i;
            }
        }
        return - 1;
    }

    public static void main(String[] args) {
        ArrayHandler array = new ArrayHandler();

        System.out.println(array.contains(new int[] {1,2,3,4},2));
        System.out.println(array.contains(new int[] {1,2,3,4},6));
        System.out.println(array.find(new int[] {1,2,3,4},6));
        System.out.println(array.find(new int[] {1,2,3,4},2));

    }
}
