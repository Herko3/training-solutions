package literals;

public class LiteralsMain {

    public static void main(String[] args) {
        String szam = "12";
        int a = 1;
        int b = 2;
        String szam2= ""+a+b;

        System.out.println(szam2);

        double quotient = 3/4;
        System.out.println(quotient);
        quotient = 3.0/4;
        System.out.println(quotient);
        quotient = 3/4.0;
        System.out.println(quotient);
        quotient = 3/4d;
        System.out.println(quotient);

        long big = 3_2444_444_444L;


        String s = "árvíztűrőtükörfúrógép";
        System.out.println(s);

        String word = "title".toUpperCase();
        System.out.println(word);

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-2));





    }
}
