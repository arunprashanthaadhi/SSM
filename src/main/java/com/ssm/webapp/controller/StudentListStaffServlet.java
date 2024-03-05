package com.ssm.webapp.controller;

import com.ssm.webapp.dao.StudentDAO;
import com.ssm.webapp.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentListStaffServlet extends HttpServlet {

    private final StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String role = (String) request.getSession().getAttribute("role");

        List<Student> studentList;
        studentList = studentDAO.getAllStudents();

        request.setAttribute("username", username);
        request.setAttribute("role", role);
        request.setAttribute("studentList", studentList);

        request.getRequestDispatcher("/studentlist.jsp").forward(request, response);
    }
}
