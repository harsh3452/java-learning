package com.harsh.jdbcapp;

import java.sql.*;
import java.util.Scanner;

public class JDBCModular {
    public static void main(String[] args){
        Connection connect = null;
//        Statement stmt = null;
//        ResultSet rs = null;
        PreparedStatement prstmt;
        String sql = "select * from studentInfo;";
        String sql2 = "UPDATE studentInfo set sage = 16 where id = 2";
        String sql3 = "INSERT INTO studentInfo(id,sname,sage,scity) VALUES (3,'Santosh', 60, 'Mumbai')";
        String query = "INSERT INTO studentInfo(id,sname,sage,scity) VALUES (?,?,?,?)";
        try{
            connect = JDBCUtil.getConnection();
            prstmt = connect.prepareStatement(query);
            System.out.println("Please enter the following details to be stored in DB");

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter your id");
            Integer id = scan.nextInt();
            scan.nextLine();

            System.out.println("Enter your name");
            String name = scan.nextLine();

            System.out.println("Enter your age");
            Integer age = scan.nextInt();
            scan.nextLine();

            System.out.println("Enter your city");
            String city = scan.nextLine();

            prstmt.setInt(1,id);
            prstmt.setString(2,name);
            prstmt.setInt(3,age);
            prstmt.setString(4,city);

            int rowsAffected = prstmt.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("unable to insert data");
            } else {
                System.out.println("data inserted");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                JDBCUtil.closeConnection(connect);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
