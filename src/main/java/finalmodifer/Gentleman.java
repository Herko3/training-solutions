package finalmodifer;

public class Gentleman {
    private static final String MESSAGE_PREFIX = "Üdv itt ";

    public String sayHello(String name){
        return MESSAGE_PREFIX + name;
    }

    public static void main(String[] args) {
        Gentleman test = new Gentleman();
        System.out.println(test.sayHello("Jack"));
    }

}
