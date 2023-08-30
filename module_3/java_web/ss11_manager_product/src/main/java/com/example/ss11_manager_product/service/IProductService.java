package com.example.ss11_manager_product.service;

import com.example.ss11_manager_product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAllProduct();
    void addProduct(Product product);
    void remove(int id);
    void update(Product product);
    Product getById(int id);
}
