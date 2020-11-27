package methodparam;

public class Measurement {

    private double[] measures;

    public Measurement(double[] measures) {
        this.measures = measures;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        int index = 0;
        for (double i : measures) {
            if (i > lower && i < upper) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public double minimum() {
        double minimum = Integer.MAX_VALUE;
        for (double i : measures) {
            if (minimum > i) {
                minimum = i;
            }
        }
        return minimum;
    }

    public double maximum() {
        double maximum = Integer.MIN_VALUE;
        for (double i : measures) {
            if (maximum < i) {
                maximum = i;
            }
        }
        return maximum;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(),maximum());
    }


}
