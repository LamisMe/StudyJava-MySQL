package com.manager_products.service;

import com.manager_products.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> getAll();
    boolean add(Product product);
    void remove(Product product);
    void update(Product product);
    List<Product> searchByName(String nameSearch);
    Product getById(int id);
    int findIndex(int id);
}
