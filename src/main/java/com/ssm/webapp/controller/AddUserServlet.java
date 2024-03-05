package com.ssm.webapp.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import com.ssm.webapp.dao.UserDAO;
import com.ssm.webapp.model.AddUser; 
import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        List<com.ssm.webapp.model.User> users = userDAO.getAllUserRoles(); 
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adduser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  AddUser addUser = new AddUser(
    		        request.getParameter("username"),
    		        request.getParameter("firstname"),
    		        request.getParameter("lastname"),
    		        request.getParameter("dob"),
    		        request.getParameter("email"),
    		        request.getParameter("address"),
    		        request.getParameter("about"),
    		        request.getParameter("contactno"),
    		        request.getParameter("password") 
    		    );

        int roleId = Integer.parseInt(request.getParameter("userRole"));
        String rollNumber = request.getParameter("rollnumber");

        UserDAO userDAO = new UserDAO();

        boolean result = userDAO.addUser(addUser, roleId, rollNumber);

        if (result) {
            response.sendRedirect("adminlanding");
        } else {
            PrintWriter out = response.getWriter();
            out.println("Failed to add user.");
        }
    }
}
