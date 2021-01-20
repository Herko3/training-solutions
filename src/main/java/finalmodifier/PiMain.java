package finalmodifier;

public class PiMain {
    public static void main(String[] args) {
        System.out.println("Pi értéke: " + CircleCalculator.PI);
        CircleCalculator test = new CircleCalculator();

        System.out.println("Az 5 sugarú kör kerülete: " + test.calculatePerimeter(5));
        System.out.println("Az 5 sugarú kör területe: " + test.calculateArea(5));

        CylinderCalculator test2 = new CylinderCalculator();
        System.out.println("CylinderCalulator");
        System.out.println("Az 5 sugarú 12 magasságú henger terület: "+ test2.calculateVolume(5,10));
        System.out.println("Az 5 sugarú 12 magasságú henger felülete: "+ test2.calculateSurface(5,10));
        CylinderCalculatorBasedOnCircle test3 = new CylinderCalculatorBasedOnCircle();
        System.out.println("CylinderCalulatorBasedOnCircle");
        System.out.println("Az 5 sugarú 12 magasságú henger terület: "+ test3.calculateVolumeBasedOn(5,10));
        System.out.println("Az 5 sugarú 12 magasságú henger felülete: "+ test3.calculateSurfaceBasedOn(5,10));


    }

}
