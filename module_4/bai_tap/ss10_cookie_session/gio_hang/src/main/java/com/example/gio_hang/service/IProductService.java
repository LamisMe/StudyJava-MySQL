package com.example.gio_hang.service;

import com.example.gio_hang.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Product findById(int id);
}
