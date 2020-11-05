package attributes.bill;

public class BillMain {

    public static void main(String[] args) {
        Bill bill = new Bill();
        Item alma = new Item("alma",13,152.5);
        Item korte = new Item("korte",6,149);
        Item sajt = new Item("sajt",3,1528);

        bill.addItem(alma);
        bill.addItem(korte);
        bill.addItem(sajt);

        System.out.println(bill.calculateTotalPrice());

    }

}
