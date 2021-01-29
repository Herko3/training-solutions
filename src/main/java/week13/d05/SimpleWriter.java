package week13.d05;

public class SimpleWriter implements RowWriter {

    @Override
    public String createLine(BillItem item) {
        return String.format("%d %s, darabja %d Ft",item.getNumber(),item.getName(),item.getUnitPrice());
    }

}
