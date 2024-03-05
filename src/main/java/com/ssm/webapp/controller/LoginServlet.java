package com.ssm.webapp.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ssm.webapp.dao.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserModel userModel = new UserModel();
        String role = userModel.validateUser(username, password);

        if (role != null) {
        	
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("role", role);

            String redirectUrl;
            switch (role) {
                case "Admin":
                    redirectUrl = "adminlanding";
                    break;
                case "Staff":
                    redirectUrl = "StaffLandingServlet";
                    break;
                case "Student":
                    redirectUrl = "StudentLandingServlet";
                    break;
                default:
                    redirectUrl = "login.html?error=true";
                    break;
            }
            response.sendRedirect(redirectUrl);
        } else {
            response.sendRedirect("login.html?error=true");
        }
    }
}

