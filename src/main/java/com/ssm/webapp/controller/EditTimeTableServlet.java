package com.ssm.webapp.controller;

import com.ssm.webapp.dao.TimetableDAO;
import com.ssm.webapp.model.TimetableEntry;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class EditTimeTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String day = request.getParameter("day");

        if (day != null && !day.isEmpty()) {
            TimetableDAO timetableDAO = new TimetableDAO();
            Optional<TimetableEntry> timetableEntryOptional = timetableDAO.getTimetableEntryByDay(day);
            if (timetableEntryOptional.isPresent()) {
                TimetableEntry timetableEntry = timetableEntryOptional.get();
                request.setAttribute("timetableEntry", timetableEntry);
                request.getRequestDispatcher("edittimetable.jsp").forward(request, response);
            } else {
                response.sendRedirect("TimetableListServlet");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String day = request.getParameter("day");
        String period1 = request.getParameter("period1");
        String period2 = request.getParameter("period2");
        String period3 = request.getParameter("period3");
        String period4 = request.getParameter("period4");
        String period5 = request.getParameter("period5");
        String period6 = request.getParameter("period6");
        String period7 = request.getParameter("period7");

        TimetableDAO timetableDAO = new TimetableDAO();
        boolean updated = timetableDAO.updateTimetableEntry(day, period1, period2, period3, period4, period5, period6, period7);
        if (updated) {
            response.sendRedirect("ViewTimeTableServlet");
        } else {
            response.getWriter().println("Error Updating Timetable");
            
        }
    }
}

