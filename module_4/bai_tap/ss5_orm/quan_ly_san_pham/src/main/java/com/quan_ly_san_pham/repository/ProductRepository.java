package com.quan_ly_san_pham.repository;

import com.quan_ly_san_pham.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product ", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void remove(int id) {
        Product productEntity = getById(id);
        entityManager.remove(productEntity);
    }

    @Transactional
    @Override
    public void update(int id, Product product) {
        Product productEntity = getById(id);
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setDescription(product.getDescription());
        productEntity.setSupplier(product.getSupplier());
        entityManager.merge(productEntity);
    }

    @Override
    public Product getById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> searchByName(String nameSearch) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where name like :name", Product.class);
        query.setParameter("name", nameSearch);
        return query.getResultList();
    }
}
