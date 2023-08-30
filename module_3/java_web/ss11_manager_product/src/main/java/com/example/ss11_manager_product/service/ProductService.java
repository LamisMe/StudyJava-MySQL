package com.example.ss11_manager_product.service;

import com.example.ss11_manager_product.model.Product;
import com.example.ss11_manager_product.repository.IProductRepository;
import com.example.ss11_manager_product.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> showAllProduct() {
        return productRepository.getAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.add(product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public Product getById(int id) {
       return productRepository.getById(id);
    }
}
