package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class OrdersDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String namePerson;
    @Column(columnDefinition = "date")
    private String borrowedDays;
    @Column(columnDefinition = "date")
    private String giveBookDays;
    @Column(unique = true)
    private String bookLoanCode;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;


    public OrdersDetail() {
    }

    public OrdersDetail(int id, String namePerson, String borrowedDays, String giveBookDays, String bookLoanCode, boolean status, Book book) {
        this.id = id;
        this.namePerson = namePerson;
        this.borrowedDays = borrowedDays;
        this.giveBookDays = giveBookDays;
        this.bookLoanCode = bookLoanCode;
        this.status = status;
        this.book = book;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public void setNamePerson(String name) {
        this.namePerson = name;
    }

    public String getBorrowedDays() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(borrowedDays, dateTimeFormatter).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setBorrowedDays(String borrowedDays) {
        this.borrowedDays = borrowedDays;
    }

    public String getGiveBookDays() {
        if (giveBookDays!=null){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(giveBookDays, dateTimeFormatter).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
       return giveBookDays;
    }

    public void setGiveBookDays(String giveBookDays) {
        this.giveBookDays = giveBookDays;
    }

    public String getBookLoanCode() {
        return bookLoanCode;
    }

    public void setBookLoanCode(String bookLoanCode) {
        this.bookLoanCode = bookLoanCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
