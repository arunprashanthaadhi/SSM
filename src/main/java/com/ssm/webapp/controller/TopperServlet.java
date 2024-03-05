package com.ssm.webapp.controller;

import com.ssm.webapp.dao.TopperDAO;
import com.ssm.webapp.model.TopperStudent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TopperServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TopperDAO topperModel = new TopperDAO();

        try {
            List<TopperStudent> overallToppers = topperModel.getOverallToppers();
            List<TopperStudent> subjectToppers = topperModel.getSubjectToppers();

            request.setAttribute("overallToppers", overallToppers);
            System.out.println("overallToppers-------------->>>>>>>>>Arun"+overallToppers);
            request.setAttribute("subjectToppers", subjectToppers);

            request.getRequestDispatcher("/toppers.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
