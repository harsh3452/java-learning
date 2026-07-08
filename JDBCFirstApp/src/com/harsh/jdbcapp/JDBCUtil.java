package com.harsh.jdbcapp;

import java.sql.*;

public class JDBCUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException { // the one who calls is responsible to implement it.Execption ducking
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "Hsp@11347";
        return DriverManager.getConnection(url,user,password);
    }
    public static void closeConnection(Connection connect, Statement statement, ResultSet resultSet) throws SQLException {
        if(resultSet != null)
            resultSet.close();
        if (statement != null)
            statement.close();
        if (connect != null)
            connect.close();

    }
}
