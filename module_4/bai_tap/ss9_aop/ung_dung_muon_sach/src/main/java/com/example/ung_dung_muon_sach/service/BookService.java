package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public Page<Book> getAll(Pageable pageable,String name) {
        return bookRepository.getAllBook(pageable,"%"+name+"%");
    }

    @Override
    public boolean addBook(Book book) {
        Book bookEntity = bookRepository.save(book);
        return bookEntity!=null;
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }
}
