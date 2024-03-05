package com.ssm.webapp.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import com.ssm.webapp.model.User;
import com.ssm.webapp.dao.UserDAO;

public class AdminLandingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Integer userId = (Integer) session.getAttribute("userId");
        UserDAO userDAO = new UserDAO();

        try {
            if (userId != null) {
                User user = userDAO.getUserById(userId);
                if (user != null) {
                    request.setAttribute("username", user.getUsername());
                    request.setAttribute("role", user.getRoleName());
                } else {
                    System.out.println("No data found for user ID: " + userId);
                }
            } else {
                System.out.println("User ID is null");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminlanding.jsp");
        dispatcher.forward(request, response);
    }
}

