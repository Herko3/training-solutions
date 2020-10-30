package localvariables;

public class DistanceMain {

    public static void main(String[] args) {

        Distance distance = new Distance(150.15,false);
        System.out.println(distance.getDistanceInKm());
        System.out.println(distance.isExact());

        int i = (int) distance.getDistanceInKm();
        System.out.println(i);

    }

}

