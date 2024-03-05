package com.ssm.webapp.controller;

import com.ssm.webapp.dao.UserProfileDAO;
import com.ssm.webapp.model.UserProfile;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        UserProfileDAO userProfileDAO = new UserProfileDAO();
        
        try {
            UserProfile userProfile = userProfileDAO.getUserProfile(username);
            if (userProfile != null) {
            	System.out.println(userProfile.getFirstName());
            	System.out.println(userProfile);

            	request.setAttribute("userProfile", userProfile);

                request.setAttribute("userProfile", userProfile);
                RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
                dispatcher.forward(request, response);
            } else {
                response.getWriter().print("Profile not found");
            }
        } catch (SQLException e) {
            throw new ServletException("Database access error:", e);
        }
    }
}
