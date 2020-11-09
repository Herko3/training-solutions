package primitivetypes;

public class PrimitiveTypes {

    public String toBinaryString(int n){
        int bitNumber = 32;
        String binary="";
        for (int number = Math.abs(n);number>0;){
            int bit = number % 2;
            binary = bit + "" + binary;
            number = number / 2;
        }
        int zeros = binary.length();
        for (int i=0; i<bitNumber-zeros;i++){
            binary = "0" + binary;
        }
        if (n<0){
            binary = "-" + binary;
        }
        return binary;
    }
}
