package com.example.thi_luon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base {
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/thi_luon";
    private static String username = "root";
    private static String password = "123456";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private Base() {

    }

    public static Connection getConnectionJavaToDB() {
        return connection;
    }
}
