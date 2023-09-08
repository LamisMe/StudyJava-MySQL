package com.example.demo_send_mail.repository;

import java.sql.*;

public class SendMailRepository implements ISendEmail{
    private static final String SELECT_SQL_NGUOI_GIAM_HO = "SELECT email FROM nguoi_nuoi where email = ? ;";

    @Override
    public String email(String email) {
        Connection connection = BaseRepo.getConnection();
        String emailDB = "";
        try {
           PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL_NGUOI_GIAM_HO);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String emailSQL = resultSet.getString("email");
                emailDB = emailSQL;
                return emailDB;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
