package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.OrdersDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IOrderDetailsRepository extends JpaRepository<OrdersDetail, Integer> {
    @Query(value = "select * from orders_detail where book_loan_code like:code", nativeQuery = true)
    Page<OrdersDetail> getAllOrderDetail(Pageable pageable, @Param("code") String codeNumber);

    @Query(value = "select * from orders_detail where book_loan_code =:code", nativeQuery = true)
    OrdersDetail findByLoadCode(@Param("code") String codeNumber);

    @Modifying
    @Transactional
    @Query(value = "delete from orders_detail where book_loan_code =:code", nativeQuery = true)
    void giveBook(@Param("code") String codeNumber);
}
