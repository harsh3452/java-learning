package com.harsh.jdbcapp;

import java.sql.*;
public class JDBCModular {
    public static void main(String[] args){
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from studentInfo;";
        String sql2 = "UPDATE studentInfo set sage = 16 where id = 2";
        String sql3 = "INSERT INTO studentInfo(id,sname,sage,scity) VALUES (3,'Santosh', 60, 'Mumbai')";
        try{
            connect = JDBCUtil.getConnection();
            stmt = connect.createStatement();
            boolean status = stmt.execute(sql3);

            if(status){
                //select
                rs = stmt.getResultSet();
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
        } finally {
            try{
                JDBCUtil.closeConnection(connect,stmt,rs);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
