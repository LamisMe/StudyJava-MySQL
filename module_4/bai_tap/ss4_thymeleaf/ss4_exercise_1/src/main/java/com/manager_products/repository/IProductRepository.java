package com.manager_products.repository;

import com.manager_products.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    boolean add(Product product);
    void remove(Product product);
    void update(Product product);
    Product getById(int id);
    int findIndex(int id);
    List<Product> searchByName(String nameSearch);
}
