package com.example.ss11_manager_product.repository;

import com.example.ss11_manager_product.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository{
    private static final String SELECT = "SELECT * FROM products";
    private static final String INSERT = "insert into products(name,price,description,supplier)\n" +
            "values (?,?,?,?);";
    private List<Product> productList = new ArrayList<>();
    @Override
    public List<Product> getAll() {
        Connection connection = BaseRepository.getConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                String supplier = resultSet.getString("supplier");
                productList.add(new Product(id,name,price,description,supplier));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public void add(Product product) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setString(4,product.getSupplier());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Product product) {

    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }
}
