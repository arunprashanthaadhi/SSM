package com.ssm.webapp.controller;

import com.ssm.webapp.model.Student;
import com.ssm.webapp.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        
        List<Student> studentList = studentDAO.getAllStudents();
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/studentdetails.jsp").forward(request, response);
    }
}
