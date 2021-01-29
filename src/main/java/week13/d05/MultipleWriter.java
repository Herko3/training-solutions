package week13.d05;

public class MultipleWriter implements RowWriter {

    @Override
    public String createLine(BillItem item) {
        return String.format("%s %d * %d = %d", item.getName(), item.getNumber(), item.getUnitPrice(), item.getNumber() * item.getUnitPrice());
    }
}
