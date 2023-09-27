package com.example.ung_dung_muon_sach.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OrdersDetailDTO implements Validator {
    private int id;
    private String namePerson;
    private String borrowedDays;
    private String bookLoanCode;

    public OrdersDetailDTO() {
    }

    public OrdersDetailDTO(int id, String namePerson, String borrowedDays, String bookLoanCode) {
        this.id = id;
        this.namePerson = namePerson;
        this.borrowedDays = borrowedDays;
        this.bookLoanCode = bookLoanCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getBorrowedDays() {
        return borrowedDays;
    }

    public void setBorrowedDays(String borrowedDays) {
        this.borrowedDays = borrowedDays;
    }

    public String getBookLoanCode() {
        return bookLoanCode;
    }

    public void setBookLoanCode(String bookLoanCode) {
        this.bookLoanCode = bookLoanCode;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
