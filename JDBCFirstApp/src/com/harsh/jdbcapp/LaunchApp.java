package com.harsh.jdbcapp;
import java.sql.*;
public class LaunchApp {
    //Load and register drivers
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "Hsp@11347";
        try {
            Connection connect = DriverManager.getConnection(url,user,password);
            Statement stmt = connect.createStatement();
            String sql = "INSERT INTO studentInfo(id,sname,sage,scity) VALUES (2,'Aditya', 22, 'Mumbai')";
            String sql2 = "UPDATE studentInfo set sage = 22 where id = 1";
            int rowsAffected = stmt.executeUpdate(sql);
            if(rowsAffected == 0){
                System.out.println("unable to insert data");
            } else {
                System.out.println("data inserted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
