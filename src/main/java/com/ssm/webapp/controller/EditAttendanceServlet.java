package com.ssm.webapp.controller;

import com.ssm.webapp.common.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditAttendanceServlet")
public class EditAttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/editattendance.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            String query = "UPDATE studentattendance SET period1=?, period2=?, period3=?, period4=?, period5=? WHERE studentattendanceid=?";

            statement = connection.prepareStatement(query);

            statement.setString(1, parameterMap.get("period1")[0]);
            statement.setString(2, parameterMap.get("period2")[0]);
            statement.setString(3, parameterMap.get("period3")[0]);
            statement.setString(4, parameterMap.get("period4")[0]);
            statement.setString(5, parameterMap.get("period5")[0]);
            statement.setString(6, parameterMap.get("studentattendanceid")[0]);

            statement.executeUpdate();

            response.sendRedirect("/editattendance.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
