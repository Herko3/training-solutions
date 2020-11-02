package stringtype;

public class StringTypeMain {

    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;
        System.out.println(message);
        message = message + 444;
        System.out.println(message);

        boolean b = message.equals("Hello John Doe");
        boolean c = message.equals("Hello John Doe444");

        System.out.println(b);
        System.out.println(c);

        String d = ""+"";
        System.out.println(d);
        System.out.println(d.length());

        String abc = "Abcde";
        System.out.println(abc.length());
        System.out.println(abc.charAt(0) + "," + abc.charAt(2));
        System.out.println(abc.substring(0,2));


    }
}
