package com.manager_products.service;

import com.manager_products.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getALl();
    void add(Product product);
    void remove(Product product);
    void update(Product product);
    List<Product> searchByName(String nameSearch);
    Product getById(int id);
}
