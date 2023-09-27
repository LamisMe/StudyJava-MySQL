package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.OrdersDetail;
import com.example.ung_dung_muon_sach.repository.IOrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailsService {
    @Autowired
    private IOrderDetailsRepository orderDetailsRepository;

    @Override
    public Page<OrdersDetail> getAll(Pageable pageable, String bookLoanCode) {
        return orderDetailsRepository.getAllOrderDetail(pageable, "%" + bookLoanCode + "%");
    }

    @Override
    public boolean addOrders(OrdersDetail ordersDetail) {
        OrdersDetail ordersDetailEntity = orderDetailsRepository.save(ordersDetail);
        return ordersDetailEntity != null;
    }

    @Override
    public void updateOrder(OrdersDetail ordersDetail) {
        orderDetailsRepository.save(ordersDetail);
    }

    @Override
    public String generateFiveNumberRandom() {
        int min = 100000;
        int max = 999999;
        int randomNum = min + (int) (Math.random() * ((max - min) + 1));
        return String.valueOf(randomNum);
    }

}
