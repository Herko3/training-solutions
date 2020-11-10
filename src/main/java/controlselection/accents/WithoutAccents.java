package controlselection.accents;

public class WithoutAccents {
    private static final String EKEZET = "áéíóöőúüú";
    private static final String PAR = "aeiooouuu";

    public char withoutAccent(char betu){
        if(EKEZET.indexOf(betu)>=0){
            return (char) (PAR.charAt(EKEZET.indexOf(betu)));
        } else {
            return betu;
        }
    }

    public static void main(String[] args) {
        WithoutAccents test = new WithoutAccents();
        System.out.println(test.withoutAccent('á'));
        System.out.println(test.withoutAccent('ú'));
        System.out.println(test.withoutAccent('e'));
    }

}
