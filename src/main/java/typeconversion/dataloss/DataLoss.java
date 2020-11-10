package typeconversion.dataloss;

public class DataLoss {

    public void dataLoss() {
        long l = 0;
        for (long kiirt = 0; kiirt < 3; ) {
            long l2 = (long) (float) l;
            if (l2 - l != 0) {
                System.out.println("szam: " + l + " binárisan: " + Long.toBinaryString(l));
                System.out.println("konvertálva: " + l2 + " binárisan: " + Long.toBinaryString(l2));
                kiirt++;
            }
            l++;
        }
    }

    public static void main(String[] args) {
        DataLoss test = new DataLoss();
        test.dataLoss();
    }
}
