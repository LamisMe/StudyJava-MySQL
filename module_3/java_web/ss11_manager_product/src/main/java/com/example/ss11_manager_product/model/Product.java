package com.example.ss11_manager_product.model;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int price;
    private String description;
    private String supplier;

    /**
     * @dev: Lâm
     * @param supplier    nhà cung cấp
     * @param description mô tả
     * @
     */

    public Product(String name, int price, String description, String supplier) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.supplier = supplier;
    }

    public Product(int id, String name, int price, String description, String supplier) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
