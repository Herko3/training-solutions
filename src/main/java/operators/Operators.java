package operators;

public class Operators {

    public boolean isBoolean(int n) {
        return n % 2 == 0;
    }

    public String multiplyByPowerOfTwo(Integer szam, Integer hatvany){
        return Integer.toBinaryString(szam << hatvany);
    }

}
