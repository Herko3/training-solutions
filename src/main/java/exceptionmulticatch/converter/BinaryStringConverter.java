package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String s) {
        if (s == null) {
            throw new NullPointerException("binaryString null");
        }
        boolean[] stat = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if ('0' == s.charAt(i)) {
                stat[i] = false;
            } else if ('1' == s.charAt(i)) {
                stat[i] = true;
            } else {
                throw new IllegalArgumentException("binaryString not valid");
            }

        }
        return stat;
    }

    public String booleanArrayToBinaryString(boolean[] stats) {
        if (stats == null || stats.length == 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        for (boolean bole : stats) {
            if (bole) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }

}
