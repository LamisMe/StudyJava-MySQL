package com.example.ung_dung_muon_sach.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookDTO implements Validator {
    private int id;
    private String nameBook;
    private String author;
    private String kindOfBook;
    private int quantity;

    public BookDTO() {

    }

    public BookDTO(int id, String nameBook, String author, String kindOfBook, int quantity) {
        this.id = id;
        this.nameBook = nameBook;
        this.author = author;
        this.kindOfBook = kindOfBook;
        this.quantity = quantity;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
