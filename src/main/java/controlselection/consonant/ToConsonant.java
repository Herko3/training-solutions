package controlselection.consonant;

public class ToConsonant {
    private static final String MGH = "aeiou";

    public char next(char betu){
        if (MGH.indexOf(betu)>=0){
            return (char) (betu+1);
        }else {
            return betu;
        }
    }

    public static void main(String[] args) {
        ToConsonant test = new ToConsonant();
        System.out.println(test.next('a'));
        System.out.println(test.next('d'));
    }
}
