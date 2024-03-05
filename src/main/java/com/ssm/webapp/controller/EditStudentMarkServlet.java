package com.ssm.webapp.controller;

import com.ssm.webapp.dao.StudentDAO;
import com.ssm.webapp.model.Student;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.List;

public class EditStudentMarkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");

        List<Student> studentList = new StudentDAO().getStudentsByRollNumber(Integer.parseInt(request.getParameter("rollnumber")));

        request.setAttribute("username", username);
        request.setAttribute("role", role);
        request.setAttribute("studentList", studentList);

        request.getRequestDispatcher("/editstudentmarks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rollNumber = Integer.parseInt(request.getParameter("rollnumber"));
        int englishMarks = Integer.parseInt(request.getParameter("english"));
        int csMarks = Integer.parseInt(request.getParameter("cs"));
        int mathsMarks = Integer.parseInt(request.getParameter("maths"));
        int physicsMarks = Integer.parseInt(request.getParameter("physics"));
        int chemistryMarks = Integer.parseInt(request.getParameter("chemistry"));

        boolean result = new StudentDAO().updateStudentMarks(rollNumber, englishMarks, csMarks, mathsMarks, physicsMarks, chemistryMarks);

        if (result) {
            response.sendRedirect("StudentListStaffServlet");
        } else {
            response.getWriter().println("Error Updating Marks");
        }
    }
}
