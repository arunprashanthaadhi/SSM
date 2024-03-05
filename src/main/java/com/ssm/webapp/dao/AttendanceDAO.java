package com.ssm.webapp.dao;

import com.ssm.webapp.common.DatabaseConnection;
import com.ssm.webapp.model.AttendanceRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class AttendanceDAO {
    private static final String INSERT_ATTENDANCE_RECORD = "INSERT INTO studentattendance (studentid, period1, period2, period3, period4, period5, attendancedate) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ATTENDANCE_RECORD = "UPDATE studentattendance SET period1 = ?, period2 = ?, period3 = ?, period4 = ?, period5 = ? WHERE studentid = ? AND attendancedate = ?";
    private static final String CHECK_ATTENDANCE_RECORD_EXISTENCE = "SELECT * FROM studentattendance WHERE studentid = ? AND attendancedate = ?";

    public void insertAttendanceRecord(int studentId, int period1, int period2, int period3, int period4, int period5, java.sql.Date attendanceDate) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_ATTENDANCE_RECORD)) {
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

    public void updateAttendanceRecord(int studentId, int period1, int period2, int period3, int period4, int period5, java.sql.Date attendanceDate) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_ATTENDANCE_RECORD)) {
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

    public boolean attendanceRecordExists(int studentId, java.sql.Date attendanceDate) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(CHECK_ATTENDANCE_RECORD_EXISTENCE)) {
            stmt.setInt(1, studentId);
            stmt.setDate(2, attendanceDate);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    public List<AttendanceRecord> getAttendanceRecords() {
        List<AttendanceRecord> attendanceRecords = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT sa.*, CONCAT(u.firstname, ' ', u.lastname) AS username FROM studentattendance sa JOIN user u ON sa.studentid = u.userid WHERE sa.attendancedate = CURDATE()");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AttendanceRecord record = new AttendanceRecord();
                record.setStudentName(rs.getString("username"));
                record.setPeriod1(rs.getBoolean("period1"));
                record.setPeriod2(rs.getBoolean("period2"));
                record.setPeriod3(rs.getBoolean("period3"));
                record.setPeriod4(rs.getBoolean("period4"));
                record.setPeriod5(rs.getBoolean("period5"));
                record.setAttendanceDate(rs.getDate("attendancedate"));
                attendanceRecords.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceRecords;
    }
}
