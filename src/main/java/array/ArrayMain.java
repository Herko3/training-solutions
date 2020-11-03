package array;

public class ArrayMain {
    public static void main(String[] args) {
        String napok[]= {"hétfő", "kedd", "szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
        System.out.println(napok[1]);
        System.out.println("String tömb hossza: " + napok.length);

        int[] hatvany= new int[5];

        for (int i=0; i<hatvany.length; i++){
            hatvany[i]= (int) Math.pow(2,i);
        }
        for (int item : hatvany){
            System.out.println(item);
        }
        boolean[] bool = new boolean [6];
        for (int i=0; i<bool.length;i++){
            bool[i] = (i+1)%2 == 0;
        }

        for (boolean item : bool){
            System.out.println(item);
        }

    }
}
