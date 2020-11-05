package attributes.person;

public class PersonMain {
    public static void main(String[] args) {
        Person test = new Person("Jack", "3564563565PA");

        System.out.println(test.personToString());
        Address address = new Address("MO","BP","utca","12145");

        test.moveTo(address);
        System.out.println(test.getAddress().addressToString());

        address.correctData("Anglia","London","Basic","1234");
        System.out.println(test.getAddress().addressToString());
    }


}
