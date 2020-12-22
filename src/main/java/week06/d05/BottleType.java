package week06.d05;

public enum BottleType {

    GLASS_BOTTLE(750),PET_BOTTLE(500);

    private int maximumAmount;

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}
