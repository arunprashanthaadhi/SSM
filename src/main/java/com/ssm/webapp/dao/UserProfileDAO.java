package com.ssm.webapp.dao;

import com.ssm.webapp.common.DatabaseConnection;
import com.ssm.webapp.model.UserProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProfileDAO {
    public UserProfile getUserProfile(String username) throws SQLException {
        UserProfile userProfile = null;
        String sql = "SELECT * FROM user WHERE username = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    userProfile = new UserProfile(
                            resultSet.getString("username"),
                            resultSet.getString("firstname"),
                            resultSet.getString("lastname"),
                            resultSet.getString("dob"),
                            resultSet.getString("email"),
                            resultSet.getString("address"),
                            resultSet.getString("about")
                    );
                }
            }
        }
        return userProfile;
    }

    public boolean updateUserProfile(UserProfile userProfile) throws SQLException {
        String sql = "UPDATE user SET firstname = ?, lastname = ?, dob = ?, email = ?, address = ?, about = ? WHERE username = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userProfile.getFirstName());
            statement.setString(2, userProfile.getLastName());
            statement.setString(3, userProfile.getDob());
            statement.setString(4, userProfile.getEmail());
            statement.setString(5, userProfile.getAddress());
            statement.setString(6, userProfile.getAbout());
            statement.setString(7, userProfile.getUsername());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }
}
