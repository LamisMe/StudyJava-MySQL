package model.person.sub_class;

import model.person.Person;

public class Customer extends Person {
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String id, String name, String dateOfBirth, String gender, String idCard, String phoneNumber, String email, String customerType, String address) {
        super(id, name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toInfoCSVCustomer() {
        return this.getId() + "," + this.getName() + "," + this.getDateOfBirth() + "," + this.getGender() + "," + this.getIdCard() + "," + this.getPhoneNumber() + "," + this.getEmail() + "," + this.getCustomerType() + "," + this.getAddress();
    }

    @Override
    public String toString() {
        return "Khách hàng: " + super.toString() +
                ", Loại Khách hàng: " + customerType +
                ", Địa chỉ: " + address;
    }
}
