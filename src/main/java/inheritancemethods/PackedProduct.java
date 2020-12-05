package inheritancemethods;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PackedProduct extends Product {

    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        int boxNumber = pieces / packingUnit;
        if (packingUnit % pieces != 0) {
            boxNumber += 1;
        }
        BigDecimal weightOfBoxes = weightOfBox.multiply(new BigDecimal(boxNumber));
        return super.totalWeight(pieces).add(weightOfBoxes).setScale(getNumberOfDecimals(), RoundingMode.HALF_UP);
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }
}
