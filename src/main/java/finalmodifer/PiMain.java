package finalmodifer;

public class PiMain {
    public static void main(String[] args) {
        CircleCalculator test = new CircleCalculator();

        System.out.println("Az 5 sugarú kör kerülete: " + test.calculatePerimeter(5));
        System.out.println("Az 5 sugarú kör területe: " + test.calculateArea(5));

        CylinderCalculator test2 = new CylinderCalculator();
        System.out.println("Az 5 sugarú 12 magasságú henger terület: "+ test2.calculateVolume(5,10));
        System.out.println("Az 5 sugarú 12 magasságú henger felülete: "+ test2.calculateSurface(5,10));

        System.out.println("Pi értéke: " + CircleCalculator.PI);

    }

}
