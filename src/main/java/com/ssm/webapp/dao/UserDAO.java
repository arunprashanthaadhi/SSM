package com.ssm.webapp.dao;

import com.ssm.webapp.common.DatabaseConnection;
import com.ssm.webapp.model.AddUser;
import com.ssm.webapp.model.User;
import com.ssm.webapp.model.UserProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	  public List<User> getAllUserRoles() {
	        List<User> roles = new ArrayList<>();
	        String query = "SELECT * FROM userrole";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                User role = new User(rs.getInt("userroleid"), null, rs.getString("userrolename"));
	                roles.add(role);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return roles;
	    }
	
    public User getUserById(int userId) throws SQLException {
        String sql = "SELECT u.userid, u.username, ur.userrolename FROM user u INNER JOIN userrole ur ON u.userroleid = ur.userroleid WHERE u.userid = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                        resultSet.getInt("userid"),
                        resultSet.getString("username"),
                        resultSet.getString("userrolename")
                    );
                }
            }
        }
        return null;
    }
    public UserProfile getUserByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new UserProfile(
                    rs.getString("username"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("dob"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("about")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean addUser(AddUser addUser, int userRoleId, String rollNumber) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;
        String userQuery = "INSERT INTO user (userroleid, firstname, lastname, rollnumber, dob, email, contactno, address, username, password, about) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(userQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, userRoleId);
            stmt.setString(2, addUser.getFirstName());
            stmt.setString(3, addUser.getLastName());
            stmt.setString(4, rollNumber);
            stmt.setString(5, addUser.getDob());
            stmt.setString(6, addUser.getEmail());
            stmt.setString(7, addUser.getContactNo());
            stmt.setString(8, addUser.getAddress());
            stmt.setString(9, addUser.getUsername());
            stmt.setString(10, addUser.getPassword()); 
            stmt.setString(11, addUser.getAbout());
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted == 0) {
                conn.rollback();
                return false;
            }

            long userId = -1;
            generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                userId = generatedKeys.getLong(1);
            } else {
                conn.rollback();
                return false;
            }

            if (userRoleId == 3) {
                String marksMappingQuery = "INSERT INTO studentmarksmapping (studentmarksmappingid, english, cs, maths, Physics, Chemistry, rollnumber, studentid) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                stmt = conn.prepareStatement(marksMappingQuery);
                stmt.setNull(1, Types.INTEGER);
                stmt.setInt(2, 0);
                stmt.setInt(3, 0);
                stmt.setInt(4, 0);
                stmt.setInt(5, 0);
                stmt.setInt(6, 0);
                stmt.setString(7, rollNumber);
                stmt.setLong(8, userId);

                int marksRowsInserted = stmt.executeUpdate();
                if (marksRowsInserted == 0) {
                    conn.rollback();
                    return false;
                }
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            if (generatedKeys != null) try { generatedKeys.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.setAutoCommit(true); conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

}