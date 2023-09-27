package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nameBook;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String kindOfBook;
    private int quantity;
    @OneToMany(mappedBy = "book" )
    Set<OrdersDetail> ordersDetailSet;

    public Book() {
    }

    public Book(int id, String nameBook, String author, String kindOfBook, int quantity, Set<OrdersDetail> ordersDetailSet) {
        this.id = id;
        this.nameBook = nameBook;
        this.author = author;
        this.kindOfBook = kindOfBook;
        this.quantity = quantity;
        this.ordersDetailSet = ordersDetailSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKindOfBook() {
        return kindOfBook;
    }

    public void setKindOfBook(String kindOfBook) {
        this.kindOfBook = kindOfBook;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}