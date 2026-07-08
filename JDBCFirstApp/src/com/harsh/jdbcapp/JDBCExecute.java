package com.harsh.jdbcapp;
import java.sql.*;
public class JDBCExecute {
    //Load and register drivers
    public static void main(String[] args){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "Hsp@11347";
            try(
                Connection connect = DriverManager.getConnection(url,user,password);
                Statement stmt = connect.createStatement();
                )
            {
                String sql = "select * from studentInfo;";
                String sql2 = "UPDATE studentInfo set sage = 16 where id = 2";
                boolean status = stmt.execute(sql);
                if(status){
                        //select
                ResultSet rs = stmt.getResultSet();
                    while(rs.next()){
                    System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
                    }
                }
                else {
                    //insert, update, delete
                    int rows = stmt.getUpdateCount();
                    if(rows==0){
                        System.out.println("Operation failed");
                    } else {
                        System.out.println("Operation success");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                 e.printStackTrace();
            }

    }
}
