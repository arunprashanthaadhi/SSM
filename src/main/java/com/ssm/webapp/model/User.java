package com.ssm.webapp.model;

public class User {
    private int userId;
    private String username;
    private String roleName;

    public User() {
    }

    public User(int userId, String username, String roleName) {
        this.userId = userId;
        this.username = username;
        this.roleName = roleName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
