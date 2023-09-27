package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.OrdersDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderDetailsRepository extends JpaRepository<OrdersDetail,Integer> {
    @Query(value = "select * from orders_detail where book_loan_code like:code",nativeQuery = true)
    Page<OrdersDetail> getAllOrderDetail(Pageable pageable, @Param("code") String codeNumber);
}
