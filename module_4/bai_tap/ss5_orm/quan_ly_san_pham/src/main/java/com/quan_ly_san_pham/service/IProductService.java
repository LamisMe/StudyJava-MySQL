package com.quan_ly_san_pham.service;

import com.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void add(Product product);
    void remove(int id);
    void update(int id,Product product);
    List<Product> searchByName(String nameSearch);
    Product getById(int id);
}
