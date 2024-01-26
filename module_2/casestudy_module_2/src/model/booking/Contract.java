package model.booking;

public class Contract {
    private int someContracts;
    private String booking;
    private float advanceDepositAmount;
    private float totalPaymentAmount;

    public Contract() {
    }

    public Contract(int someContracts, String booking, float advanceDepositAmount, float totalPaymentAmount) {
        this.someContracts = someContracts;
        this.booking = booking;
        this.advanceDepositAmount = advanceDepositAmount;
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public int getSomeContracts() {
        return someContracts;
    }

    public void setSomeContracts(int someContracts) {
        this.someContracts = someContracts;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public float getAdvanceDepositAmount() {
        return advanceDepositAmount;
    }

    public void setAdvanceDepositAmount(float advanceDepositAmount) {
        this.advanceDepositAmount = advanceDepositAmount;
    }

    public float getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(float totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public String toContract() {
        return this.someContracts + "," + this.booking + "," + this.advanceDepositAmount + "," + this.totalPaymentAmount;
    }


    @Override
    public String toString() {
        return "Hợp đồng: " +
                "số hợp đồng: " + someContracts +
                ", mã booking: " + booking +
                ", số tiền cọc trước: " + advanceDepositAmount +
                ", tổng số tiền thanh toán: " + totalPaymentAmount;
    }
}
