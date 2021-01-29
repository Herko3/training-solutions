package week13.d05;

import java.util.List;

public class BillWriter {

    public String writeBills(List<BillItem> items, RowWriter writer){
        StringBuilder sb = new StringBuilder();
        for(BillItem item : items){
            sb.append(writer.createLine(item));
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        BillWriter billWriter = new BillWriter();
        List<BillItem> items = List.of(
                new BillItem("kenyér",3,10),
                new BillItem("tej",5,20)
        );
//        String result = billWriter.writeBills(items,new SimpleWriter());
        String result = billWriter.writeBills(items,new MultipleWriter());
        System.out.println(result);
    }

}
