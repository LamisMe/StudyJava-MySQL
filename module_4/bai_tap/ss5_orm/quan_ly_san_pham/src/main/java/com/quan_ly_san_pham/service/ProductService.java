package com.quan_ly_san_pham.service;

import com.quan_ly_san_pham.model.Product;
import com.quan_ly_san_pham.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public List<Product> searchByName(String nameSearch) {
        return productRepository.searchByName("%"+nameSearch+"%");
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }
}