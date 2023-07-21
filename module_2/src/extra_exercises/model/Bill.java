package extra_exercises.model;

import java.util.Objects;

public class Bill  {
    private String codeBill;
    private String codePerson ;
    private String invoiceDate;
    private int quantity;
    private long unitPrice;
    private long intoMoney;

    public Bill() {
    }

    public Bill(String codeBill, String invoiceDate, int quantity, long unitPrice, long intoMoney) {
        this.codeBill = codeBill;
        this.invoiceDate = invoiceDate;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.intoMoney = intoMoney;
    }

    public Bill(String codeBill, String codePerson, String invoiceDate, int quantity, long unitPrice, long intoMoney) {
        this.codeBill = codeBill;
        this.codePerson = codePerson;
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

    public String getPerson() {
        return codePerson;
    }

    public void setPerson(String codePerson) {
        this.codePerson = codePerson;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(codeBill, bill.codeBill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBill);
    }

    public String infoBillCSV(){
        return this.codeBill+","+this.codePerson+","+this.invoiceDate+","+this.quantity+","+this.unitPrice+","+this.intoMoney;
}
    @Override
    public String toString() {
        return "Hóa đơn: " +
                "Mã hóa đơn: " + codeBill +
                ", mã khách hàng: " + codePerson +
                ", ngày ra hoá đơn: " + invoiceDate +
                ", số lượng: " + quantity +
                ", đơn giá: " + unitPrice +
                ", thành tiền: " + intoMoney;
    }
}
