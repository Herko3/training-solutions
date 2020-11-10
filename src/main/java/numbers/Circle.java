package numbers;

public class Circle {

    public static final double PI = 3.14;

    private int diameter;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter(){
        return diameter*PI;
    }

    public double area(){
        return diameter * diameter * PI /4;
    }

}
