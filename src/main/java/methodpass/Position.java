package methodpass;

public class Position {

    private double posX;
    private double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double distanceFrom(Position position){
        if(position == null){
            throw new IllegalArgumentException("No position to get data from");
        }
        return Math.sqrt(Math.pow((posX-position.posX),2)+Math.pow(posY-position.getPosY(),2));
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
}
