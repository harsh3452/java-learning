package com.harsh.jdbcapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCBatchProcessing {
    public static void main(String[] args){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String query = "UPDATE studentInfo set sage = ? where id = ?";
        try {

            con = JDBCUtil.getConnection();

            pstmt = con.prepareStatement(query);


            pstmt.setInt(1,20);
            pstmt.setInt(2,2);
            pstmt.addBatch();
            pstmt.setInt(1,40);
            pstmt.setInt(2,3);
            pstmt.addBatch();
            pstmt.setInt(1,50);
            pstmt.setInt(2,5);
            pstmt.addBatch();

            int[] result = pstmt.executeBatch();



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
