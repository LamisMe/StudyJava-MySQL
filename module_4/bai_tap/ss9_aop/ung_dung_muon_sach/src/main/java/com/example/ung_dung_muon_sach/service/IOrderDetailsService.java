package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.OrdersDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderDetailsService {
    Page<OrdersDetail> getAll(Pageable pageable, String bookLoanCode);
    boolean addOrders(OrdersDetail ordersDetail);
    void updateOrder(OrdersDetail ordersDetail);
    String generateFiveNumberRandom();
}
