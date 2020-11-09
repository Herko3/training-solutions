package enumtype.unit;

public enum LengthUnit {
    MILLIMETER(true,1d), CENTIMETER(true,10d), DECIMETER(true,100d), METER(true,1000d),
    YARD(false,914.4), FOOT(false,304.8), INCH(false,25.4);
    private final boolean si;
    private final double toMm;

    LengthUnit(boolean si, double toMm) {
        this.si = si;
        this.toMm = toMm;
    }

    public boolean isSi() {
        return si;
    }

    public double getToMm() {
        return toMm;
    }
}
