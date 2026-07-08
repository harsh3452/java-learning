package com.harsh.jdbcapp;
import java.sql.*;
public class LaunchApp2 {
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
            String sql = "SELECT * from studentInfo";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
