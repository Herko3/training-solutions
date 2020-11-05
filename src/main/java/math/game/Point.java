package math.game;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance (Point other){
        double xTav = Math.abs(x - other.x);
        double yTav = Math.abs(y - other.y);
        return xTav+yTav;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

//    public static void main(String[] args) {
//        Point test1 = new Point(5,2);
//        Point test2 = new Point(2,1);
//
//        System.out.println(test1.distance(test2));
//    }
}
