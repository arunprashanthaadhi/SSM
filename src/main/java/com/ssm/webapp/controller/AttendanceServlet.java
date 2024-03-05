package com.ssm.webapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import com.ssm.webapp.model.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String URL = "jdbc:mysql://localhost:3306/final";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] studentIds = request.getParameterValues("studentIds");
        String[] period1 = request.getParameterValues("period1");
        String[] period2 = request.getParameterValues("period2");
        String[] period3 = request.getParameterValues("period3");
        String[] period4 = request.getParameterValues("period4");
        String[] period5 = request.getParameterValues("period5");
        String[] attendanceDates = request.getParameterValues("attendanceDates");

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            for (int i = 0; i < studentIds.length; i++) {
                java.util.Date parsedDate = null;
                try {
                    parsedDate = inputFormat.parse(attendanceDates[i]);
                } catch (ParseException e) {
                    throw new ServletException("Error parsing attendance date for student ID " + studentIds[i], e);
                }
                Date attendanceDate = new Date(parsedDate.getTime());

                int period1Value = parseAttendanceToInt(period1[i]);
                int period2Value = parseAttendanceToInt(period2[i]);
                int period3Value = parseAttendanceToInt(period3[i]);
                int period4Value = parseAttendanceToInt(period4[i]);
                int period5Value = parseAttendanceToInt(period5[i]);
                int studentId = Integer.parseInt(studentIds[i]);
                

                if (attendanceRecordExists(conn, studentId, attendanceDate)) {
                    updateAttendanceRecord(conn, studentId, period1Value, period2Value, period3Value, period4Value, period5Value, attendanceDate);
                } else {
                    insertAttendanceRecord(conn, studentId, period1Value, period2Value, period3Value, period4Value, period5Value, attendanceDate);
                }
            }
            response.sendRedirect("ViewAttendanceStaffServlet");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
    private boolean attendanceRecordExists(Connection conn, int studentId, Date attendanceDate) throws SQLException {
        String query = "SELECT * FROM studentattendance WHERE studentid = ? AND attendancedate = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setDate(2, attendanceDate);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    private void updateAttendanceRecord(Connection conn, int studentId, int period1, int period2, int period3, int period4, int period5, Date attendanceDate) throws SQLException {
        String query = "UPDATE studentattendance SET period1 = ?, period2 = ?, period3 = ?, period4 = ?, period5 = ? WHERE studentid = ? AND attendancedate = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, period1);
            stmt.setInt(2, period2);
            stmt.setInt(3, period3);
            stmt.setInt(4, period4);
            stmt.setInt(5, period5);
            stmt.setInt(6, studentId);
            stmt.setDate(7, attendanceDate);
            stmt.executeUpdate();
        }
    }

    private void insertAttendanceRecord(Connection conn, int studentId, int period1, int period2, int period3, int period4, int period5, Date attendanceDate) throws SQLException {
        String query = "INSERT INTO studentattendance (studentid, period1, period2, period3, period4, period5, attendancedate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, period1);
            stmt.setInt(3, period2);
            stmt.setInt(4, period3);
            stmt.setInt(5, period4);
            stmt.setInt(6, period5);
            stmt.setDate(7, attendanceDate);
            stmt.executeUpdate();
        }
    }

    private int parseAttendanceToInt(String attendance) {
        return "P".equals(attendance) ? 1 : 0;
    }
}