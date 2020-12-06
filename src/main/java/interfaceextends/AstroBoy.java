package interfaceextends;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot {

    public static final long ALTITUDE = 5;

    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();

    public AstroBoy(Point position) {
        this.position = position;
    }

    public void walkTo(Point position){
        moveTo(position);
    }

    public void flyTo(Point position){
        moveTo(new Point (position.getX(),position.getY(),ALTITUDE));
    }

    @Override
    public void liftTo(long altitude) {
        moveTo(new Point(position.getX(), position.getY(), altitude));
    }

    @Override
    public void moveTo(Point position) {
        this.position = position;
        path.add(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        liftTo(ALTITUDE);
        flyTo(position);
        liftTo(position.getZ());

    }

    @Override
    public void rotate(int angle) {
        this.angle +=angle;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    public long getAltitude() {
        return position.getZ();
    }
}
