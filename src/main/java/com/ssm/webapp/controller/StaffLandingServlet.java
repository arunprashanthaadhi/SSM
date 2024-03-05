package com.ssm.webapp.controller;

import com.ssm.webapp.dao.UserDAO;
import com.ssm.webapp.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

public class StaffLandingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        UserDAO userDAO = new UserDAO();

        try {
            if (userId != null) {
            	 User user = userDAO.getUserById(userId);
                
                if (user != null) {
                    request.setAttribute("userProfile", user);
                } else {
                    System.out.println("No data found for user ID: " + userId);
                }
            } else {
                System.out.println("User ID is null");
            }
        } catch (SQLException e) {
            throw new ServletException("Database access error:", e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/stafflanding.jsp");
        dispatcher.forward(request, response);
    }
}
