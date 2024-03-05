package com.ssm.webapp.controller;

import com.ssm.webapp.dao.AttendanceDAO;
import com.ssm.webapp.model.AttendanceRecord;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewAttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");
        System.out.println("--------->>>>>>"+request.getSession().getAttribute("role"));
        PrintWriter out = response.getWriter();
        
        AttendanceDAO attendanceDAO = new AttendanceDAO();
        List<AttendanceRecord> attendanceRecords = attendanceDAO.getAttendanceRecords();
        request.setAttribute("attendanceRecords", attendanceRecords);
        
        if ("Admin".equals(role)) {
            request.getRequestDispatcher("/viewattendance.jsp").forward(request, response);
        } else if ("Staff".equals(role)) {
            request.getRequestDispatcher("/viewattendancestaff.jsp").forward(request, response);
        } else {
            out.println("Unauthorized User");
        }
    }
}
