package com.quan_ly_san_pham.repository;

import com.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    void add(Product product);
    void remove(int id);
    void update(int id,Product product);
    Product getById(int id);
    List<Product> searchByName(String nameSearch);
}
