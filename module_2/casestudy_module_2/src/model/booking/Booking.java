package model.booking;

import model.facility.Facility;
import model.person.sub_class.Customer;

public class Booking {
    private String bookingCode;
    private String bookingDate;
    private String rentalStartDate;
    private String rentalEndDate;
    private String customer;
    private String facility;

    public Booking() {
    }

    public Booking(String bookingCode, String bookingDate, String rentalStartDate, String rentalEndDate, String customer, String facility) {
        this.bookingCode = bookingCode;
        this.bookingDate = bookingDate;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.customer = customer;
        this.facility = facility;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(String rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public String getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(String rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String toInfoBooking() {
        return this.bookingCode + "," + this.bookingDate + "," + this.rentalStartDate + "," + this.rentalEndDate + "," + this.customer + "," + this.facility;
    }

    @Override
    public String toString() {
        return "Booking: " +
                "mã booking: " + bookingCode +
                ", ngày booking: " + bookingDate +
                ", ngày bắt đầu thuê: " + rentalStartDate +
                ", ngày kết thúc thuê: " + rentalEndDate +
                ", mã khách hàng" + customer+
                ", mã dịch vụ: " + facility;
    }
}
