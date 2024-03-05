package com.ssm.webapp.dao;

import com.ssm.webapp.common.DatabaseConnection;
import com.ssm.webapp.model.TimetableEntry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TimetableDAO {

    public List<TimetableEntry> getAllTimetableEntries() {
        List<TimetableEntry> timetableEntries = new ArrayList<>();
        String query = "SELECT * FROM timetable";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                TimetableEntry entry = new TimetableEntry(
                        resultSet.getInt("timetableid"),
                        resultSet.getString("day"),
                        resultSet.getString("period1"),
                        resultSet.getString("period2"),
                        resultSet.getString("period3"),
                        resultSet.getString("period4"),
                        resultSet.getString("period5"),
                        resultSet.getString("period6"),
                        resultSet.getString("period7"));
                timetableEntries.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timetableEntries;
    }

    public Optional<TimetableEntry> getTimetableEntryByDay(String day) {
        String query = "SELECT * FROM timetable WHERE day = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, day);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    TimetableEntry entry = new TimetableEntry(
                            resultSet.getInt("timetableid"),
                            resultSet.getString("day"),
                            resultSet.getString("period1"),
                            resultSet.getString("period2"),
                            resultSet.getString("period3"),
                            resultSet.getString("period4"),
                            resultSet.getString("period5"),
                            resultSet.getString("period6"),
                            resultSet.getString("period7"));
                    System.out.println("entry---------->>>>>>>>"+entry);
                    return Optional.of(entry);
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean updateTimetableEntry(String day, String period1, String period2, String period3, String period4, String period5, String period6, String period7) {
        String query = "UPDATE timetable SET period1=?, period2=?, period3=?, period4=?, period5=?, period6=?, period7=? WHERE day=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, period1);
            statement.setString(2, period2);
            statement.setString(3, period3);
            statement.setString(4, period4);
            statement.setString(5, period5);
            statement.setString(6, period6);
            statement.setString(7, period7);
            statement.setString(8, day);
            
            System.out.println("Executing SQL query: " + statement.toString());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
