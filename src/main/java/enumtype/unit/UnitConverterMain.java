package enumtype.unit;

public class UnitConverterMain {

    public static void main(String[] args) {
        UnitConverter converter = new UnitConverter();

        System.out.println((converter.convert(150.456432,LengthUnit.YARD,LengthUnit.METER)));
        System.out.println(converter.siUnits());
    }
}
