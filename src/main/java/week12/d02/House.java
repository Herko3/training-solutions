package week12.d02;

public class House implements Comparable<House>{

    private int houseNumber;
    private int width;
    private String colorOfHedge;

    public House(int houseNumber, int width, String colorOfHedge) {
        this.houseNumber = houseNumber;
        this.width = width;
        this.colorOfHedge = colorOfHedge;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getWidth() {
        return width;
    }

    public String getColorOfHedge() {
        return colorOfHedge;
    }

    @Override
    public int compareTo(House o) {
        return width - o.getWidth();
    }
}
