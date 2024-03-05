package com.ssm.webapp.controller;

import com.ssm.webapp.dao.UserDAO;
import com.ssm.webapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class StudentLandingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            UserDAO userDAO = new UserDAO();
            try {
                User user = userDAO.getUserById(userId);

                if (user != null) {
                    request.setAttribute("username", user.getUsername());
                    request.setAttribute("role", user.getRoleName());
                } else {
                    System.out.println("No data found for user ID: " + userId);
                }
            } catch (SQLException e) {
                System.out.println("A database error occurred.");
                e.printStackTrace();
                request.setAttribute("errorMessage", "Database error: Unable to retrieve user information.");
            }
        } else {
            System.out.println("User ID is null");
        }

        request.getRequestDispatcher("/studentlanding.jsp").forward(request, response);
    }
}
