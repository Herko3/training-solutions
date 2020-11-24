package immutable;

public class Satellite {

    private CelestialCoordinates destinationCoordinates;
    private final String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if(isEmpty(registerIdent)){
            throw new IllegalArgumentException("Register ident must not be empty!");
        }

        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff){
        int newX = destinationCoordinates.getX() + diff.getX();
        int newY = destinationCoordinates.getY() + diff.getY();
        int newZ = destinationCoordinates.getZ() + diff.getZ();
        this.destinationCoordinates = new CelestialCoordinates(newX,newY,newZ);
    }

    private boolean isEmpty(String s){
        if(s == null || s.trim().equals("")){
            return true;
        }
        return false;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    @Override
    public String toString() {
        return registerIdent + ": " + destinationCoordinates;
    }
}
