package com.codegym.case_study_group_1.model;

import javax.persistence.*;

@Entity
@Table(name = "yards")
public class YardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(columnDefinition = "text",nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;
    private String image;
    @Column(columnDefinition = "bit(1) default 0")
    private boolean status;
    @Column(columnDefinition = "bit(1) default 0")
    private boolean isDeleted;

    public YardEntity() {
    }

    public YardEntity(int id, String name, String address, String description, double price, String image, boolean status, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.price = price;
        this.image = image;
        this.status = status;
        this.isDeleted = isDeleted;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
