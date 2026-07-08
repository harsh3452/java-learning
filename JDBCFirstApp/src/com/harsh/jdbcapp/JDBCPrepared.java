package com.harsh.jdbcapp;
import java.sql.*;
import java.util.Scanner;

public class JDBCPrepared {
    public static void main(String[] args){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String query = "SELECT * from studentInfo";
        try {

            con = JDBCUtil.getConnection();

            pstmt = con.prepareStatement(query);

            // Set parameters here
            // pstmt.setInt(1, ...);
            // pstmt.setString(2, ...);

            rs = pstmt.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {

            try {
                if (pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();

                JDBCUtil.closeConnection(con);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
