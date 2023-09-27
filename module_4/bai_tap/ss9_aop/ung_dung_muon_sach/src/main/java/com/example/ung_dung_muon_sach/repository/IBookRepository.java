package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select * from books where name_book like:nameSearch",nativeQuery = true)
    Page<Book> getAllBook(Pageable pageable, @Param("nameSearch") String nameSearch);
}
