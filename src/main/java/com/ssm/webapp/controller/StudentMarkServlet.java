package com.ssm.webapp.controller;

import com.ssm.webapp.dao.StudentDAO;
import com.ssm.webapp.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class StudentMarkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");
        
        if (!"Student".equals(role)) {
            response.sendRedirect("login.jsp");
            return;
        }

        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.getStudentMarksByUsername(username);

        request.setAttribute("username", username);
        request.setAttribute("role", role);
        request.setAttribute("studentList", studentList);

        request.getRequestDispatcher("/studentmarks.jsp").forward(request, response);
    }
}
