package com.ssm.webapp.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.SQLException;

import com.ssm.webapp.dao.StudentDAO;

public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentIdParam = request.getParameter("userid");
        if (studentIdParam == null || studentIdParam.isEmpty()) {
            response.getWriter().println("Student ID is missing or empty");
            return;
        }

        int studentId;
        try {
            studentId = Integer.parseInt(studentIdParam);
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid student ID: " + studentIdParam);
            return;
        }

        StudentDAO studentDAO = new StudentDAO();
        try {
            boolean isDeleted = studentDAO.deleteStudent(studentId);

            if (isDeleted) {
                response.sendRedirect("StudentListServlet");
            } else {
                response.getWriter().println("Student not found with ID: " + studentId);
            }
        } catch (SQLException e) {
            throw new ServletException("Database connection problem.", e);
        }
    }
}

