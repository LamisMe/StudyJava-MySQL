package com.manager_products.service;

import com.manager_products.model.Product;
import com.manager_products.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> getALl() {
        return productRepository.getALl();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void remove(Product product) {
        productRepository.remove(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public List<Product> searchByName(String nameSearch) {
        return productRepository.searchByName(nameSearch);
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }
}
