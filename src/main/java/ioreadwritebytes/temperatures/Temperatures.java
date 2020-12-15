package ioreadwritebytes.temperatures;

public class Temperatures {

    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        double sum = 0;
        for (byte actual : data) {
            sum += actual;
        }
        return sum / data.length;
    }

    public double getMonthAverage() {
        double sum = 0;
        for (int i = data.length - 1; i > data.length - 31; i--)
            sum += data[i];

        return sum / 30;
    }

}
