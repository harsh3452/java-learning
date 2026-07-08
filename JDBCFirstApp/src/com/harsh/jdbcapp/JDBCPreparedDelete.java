package com.harsh.jdbcapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCPreparedDelete {
    public static void main(String[] args){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String query = "DELETE FROM studentInfo where id = ?";
        try {

            con = JDBCUtil.getConnection();

            pstmt = con.prepareStatement(query);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter id to delete");
            int id = sc.nextInt();
            sc.nextLine();

            pstmt.setInt(1,id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Operation successful.");
            } else {
                System.out.println("Operation failed.");
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
