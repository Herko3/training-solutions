package week06d02;

public class NumberOfProducts {

    private int numberOfFrozen;
    private int numberOfOther;
    private int numberOfDairy;
    private int numberOfBakedgoods;

    public NumberOfProducts(int numberOfFrozen, int numberOfOther, int numberOfDairy, int numberOfBakedgoods) {
        this.numberOfFrozen = numberOfFrozen;
        this.numberOfOther = numberOfOther;
        this.numberOfDairy = numberOfDairy;
        this.numberOfBakedgoods = numberOfBakedgoods;
    }

    public int getNumberOfFrozen() {
        return numberOfFrozen;
    }

    public int getNumberOfOther() {
        return numberOfOther;
    }

    public int getNumberOfDairy() {
        return numberOfDairy;
    }

    public int getNumberOfBakedgoods() {
        return numberOfBakedgoods;
    }
}
