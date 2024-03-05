package com.ssm.webapp.controller;

import com.ssm.webapp.dao.TimetableDAO;
import com.ssm.webapp.model.TimetableEntry;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TimeTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TimetableDAO timetableDAO = new TimetableDAO();
        List<TimetableEntry> timetableEntries = timetableDAO.getAllTimetableEntries();

        request.setAttribute("timetableEntries", timetableEntries);
        request.getRequestDispatcher("timetable.jsp").forward(request, response);
    }
}
