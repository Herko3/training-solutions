package week03.d04;

public class PhoneParser {

    public Phone parsePhone(String number){
        String[] part = number.split("-");
        int prefix=Integer.parseInt(part[0]);
        int num = Integer.parseInt(part[1]);
        return new Phone(prefix,num);
    }

    public static void main(String[] args) {
        PhoneParser test = new PhoneParser();
        System.out.println(test.parsePhone("30-1234567"));

    }
}
