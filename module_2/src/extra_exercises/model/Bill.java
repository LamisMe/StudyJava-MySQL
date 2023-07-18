package extra_exercises.model;

public class Bill {
    private String codeBill;
    private Person person ;
    private String invoiceDate;
    private int quantity;
    private long unitPrice;
    private long intoMoney;

    public Bill() {
    }

    public Bill(String codeBill, Person person, String invoiceDate, int quantity, long unitPrice, long intoMoney) {
        this.codeBill = codeBill;
        this.person = person;
        this.invoiceDate = invoiceDate;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.intoMoney = intoMoney;
    }

    public String getCodeBill() {
        return codeBill;
    }

    public void setCodeBill(String codeBill) {
        this.codeBill = codeBill;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getIntoMoney() {
        return intoMoney;
    }

    public void setIntoMoney(long intoMoney) {
        this.intoMoney = intoMoney;
    }

    @Override
    public String toString() {
        return "Hóa đơn: " +
                "Mã hóa đơn" + codeBill +
                ", mã khách hàng: " + person +
                ", ngày ra hoá đơn: " + invoiceDate +
                ", số lượng: " + quantity +
                ", đơn giá: " + unitPrice +
                ", thành tiền: " + intoMoney;
    }
}
