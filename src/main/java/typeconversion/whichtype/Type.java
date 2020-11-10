package typeconversion.whichtype;

public enum Type {
    BYTE(-128,127),SHORT(-32768,32767),INT((long)-Math.pow(2,31),(long)Math.pow(2,31)-1);
    private final long min;
    private final long max;

    Type(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public long getMin() {
        return min;
    }

    public long getMax() {
        return max;
    }
}
