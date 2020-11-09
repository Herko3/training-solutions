package primitivetypes;

public class PrimitiveTypesMain {

    public static void main(String[] args) {
        PrimitiveTypes prim = new PrimitiveTypes();
        System.out.println(prim.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-10));

        System.out.println(new Integer(1) + new Integer(2) );
    }
}
