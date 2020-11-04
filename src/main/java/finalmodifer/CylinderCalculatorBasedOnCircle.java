package finalmodifer;

public class CylinderCalculatorBasedOnCircle {

    public double calculateVolumeBasedOn(double r,double h){
        return new CircleCalculator().calculateArea(r)*h;
    }

    public double calculateSurfaceBasedOn(double r, double h){
        return new CircleCalculator().calculatePerimeter(r) * 2+ 2*CircleCalculator.PI*r*h;
    }


}
