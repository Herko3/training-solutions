package finalmodifier;

public class CylinderCalculator {

    public double calculateVolume(double r,double h){
        return CircleCalculator.PI * r*r*h;
    }

    public double calculateSurface (double r, double h){
        return 2*CircleCalculator.PI*r*r+ 2*CircleCalculator.PI*r*h;
    }

}
