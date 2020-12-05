package abstractclass.gamecharacter;

public class Point {

    private final long X;
    private final long Y;

    public Point(long posX, long posY) {
        this.X = posX;
        this.Y = posY;
    }

    public long distance(Point otherPoint){
        return (long) Math.sqrt(Math.pow((X -otherPoint.getX()),2)+Math.pow((Y -otherPoint.getY()),2));
    }

    public long getX() {
        return X;
    }

    public long getY() {
        return Y;
    }
}
