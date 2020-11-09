package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        Operators test = new Operators();

        System.out.println(test.isBoolean(10));
        System.out.println(test.isBoolean(11));


        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(16 <<1));
        System.out.println(Integer.toBinaryString(16 >>1));
        System.out.println(Integer.toBinaryString(13 ));
        System.out.println(Integer.toBinaryString(13 <<1));
        System.out.println(Integer.toBinaryString(13 >>1));
        System.out.println("Power of two");
        System.out.println(Integer.toBinaryString(36));
        System.out.println(test.multiplyByPowerOfTwo(9,2));


        System.out.println("bonus");
        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
//        int j = Integer.parseInt(s,2);
//        System.out.println(j);
        System.out.println(Long.valueOf(s, 2).intValue());
        // 32bit(int) vs 64bit(long)? az int akkora számra kifut a tartományból

        System.out.println(0333); //a 0-val kezdődő számot átkonvertálja oktálisra

    }

}
