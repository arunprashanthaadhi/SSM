package com.ssm.webapp.dao;

import com.ssm.webapp.common.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public String validateUser(String username, String password) {
        String userRole = null;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT u.username, ur.userrolename FROM user u INNER JOIN userrole ur ON u.userroleid = ur.userroleid WHERE u.username = ? AND u.password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        userRole = rs.getString("userrolename");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRole;
    }
}

