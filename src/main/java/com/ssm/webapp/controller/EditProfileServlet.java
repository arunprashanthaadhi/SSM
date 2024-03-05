package com.ssm.webapp.controller;

import com.ssm.webapp.model.UserProfile;
import com.ssm.webapp.dao.UserProfileDAO;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        if (username != null && !username.isEmpty()) {
            UserProfileDAO userProfileModel = new UserProfileDAO();

            try {
                UserProfile userProfile = userProfileModel.getUserProfile(username);
                request.setAttribute("userProfile", userProfile);
                System.out.println("userProfile------------->>>>>>>>>>"+userProfile);
                request.getRequestDispatcher("editprofile.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String about = request.getParameter("about");

        UserProfile userProfile = new UserProfile(username, firstname, lastname, dob, email, address, about);
        UserProfileDAO userProfileModel = new UserProfileDAO();

        try {
            boolean updated = userProfileModel.updateUserProfile(userProfile);
            if (updated) {
                response.sendRedirect("adminlanding.jsp");
            } else {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
