package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> getAll(Pageable pageable, String name);
    boolean addBook(Book book);
    Book findById(int id);
}
