package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person test = new Person("Pisti",25);
        Person test2 = test;

        test2.setName("Pityu");

        System.out.println(test.getName() + " " + test.getAge());
        System.out.println(test2.getName() + " " + test2.getAge());

        int a = 24;
        int b=a;
        b+=1;
        System.out.println(a);
        System.out.println(b);

        test2 = new Person("Sanyi",28);
        System.out.println(test.getName() + " " + test.getAge());
        System.out.println(test2.getName() + " " + test2.getAge());

    }

}
