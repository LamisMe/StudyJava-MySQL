package com.manager_products.repository;

import com.manager_products.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Sting Dâu", 9000, "Vị dâu, uống là mê", "PepsiCo "));
        productList.add(new Product(2, "Sting Vàng", 9000, "Vị tăng lực, uống là mê", "PepsiCo "));
        productList.add(new Product(3, "RockStar", 10000, "Tăng lực vị mật ong", "PepsiCo "));
        productList.add(new Product(4, "RedBull", 15000, "Tăng lực sảng khoái", "Red Bull GmbH "));
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public boolean add(Product product) {
        if (getById(product.getId()) == null){
            productList.add(product);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void remove(Product product) {
        productList.remove(product);
    }

    @Override
    public void update(Product product) {
        int index = findIndex(product.getId());
        productList.set(index, product);
    }

    @Override
    public Product getById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public int findIndex(int id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public List<Product> searchByName(String nameSearch) {
        List<Product> products = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().contains(nameSearch)) {
                products.add(p);
            }
        }
        return products;
    }
}
