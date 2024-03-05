package com.ssm.webapp.dao;

import com.ssm.webapp.common.DatabaseConnection;
import com.ssm.webapp.model.TopperStudent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopperDAO {
    public List<TopperStudent> getOverallToppers() throws SQLException {
        List<TopperStudent> overallTopperList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String overallTopperQuery = "SELECT CONCAT(u.firstname, ' ', u.lastname) AS fullname, SUM(smm.english + smm.cs + smm.maths + smm.physics + smm.chemistry) AS totalMarks " +
                                        "FROM user u JOIN studentmarksmapping smm ON u.userid = smm.studentid " +
                                        "GROUP BY u.userid ORDER BY totalMarks DESC ";

            try (PreparedStatement overallStmt = conn.prepareStatement(overallTopperQuery)) {
                try (ResultSet overallRs = overallStmt.executeQuery()) {
                    while (overallRs.next()) {
                        TopperStudent overallTopper = new TopperStudent();
                        overallTopper.setFullName(overallRs.getString("fullname")); 
                        overallTopper.setTotalMarks(overallRs.getInt("totalMarks"));
                        overallTopperList.add(overallTopper);
                        System.out.println("overallTopperList------------->>>>>>>>>>>>"+overallTopperList);
                    }
                }
            }
        }

        return overallTopperList;
    }

    public List<TopperStudent> getSubjectToppers() throws SQLException {
        List<TopperStudent> subjectTopperList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String subjectTopperQuery = "(SELECT 'English' AS subject, CONCAT(u.firstname, u.lastname) AS fullname, smm.english AS subjectMark " +
                                        "FROM user u JOIN studentmarksmapping smm ON u.userid = smm.studentid " +
                                        "ORDER BY smm.english DESC LIMIT 1) " +

                                        "UNION " +

                                        "(SELECT 'CS' AS subject, CONCAT(u.firstname, u.lastname) AS fullname, smm.cs AS subjectMark " +
                                        "FROM user u JOIN studentmarksmapping smm ON u.userid = smm.studentid " +
                                        "ORDER BY smm.cs DESC LIMIT 1) " +

                                        "UNION " +
                                        
                                        "(SELECT 'Maths' AS subject, CONCAT(u.firstname, u.lastname) AS fullname, smm.maths AS subjectMark " +
                                        "FROM user u JOIN studentmarksmapping smm ON u.userid = smm.studentid " +
                                        "ORDER BY smm.maths DESC LIMIT 1) " +

                                        "UNION " +
                                        
                                        "(SELECT 'Physics' AS subject, CONCAT(u.firstname, u.lastname) AS fullname, smm.physics AS subjectMark " +
                                        "FROM user u JOIN studentmarksmapping smm ON u.userid = smm.studentid " +
                                        "ORDER BY smm.physics DESC LIMIT 1) " +

                                        "UNION " +
                                        
                                        "(SELECT 'Chemistry' AS subject, CONCAT(u.firstname, u.lastname) AS fullname, smm.chemistry AS subjectMark " +
                                        "FROM user u JOIN studentmarksmapping smm ON u.userid = smm.studentid " +
                                        "ORDER BY smm.chemistry DESC LIMIT 1)";

            try (PreparedStatement subjectStmt = conn.prepareStatement(subjectTopperQuery)) {
                try (ResultSet subjectRs = subjectStmt.executeQuery()) {
                    while (subjectRs.next()) {
                        TopperStudent subjectTopper = new TopperStudent();
                        subjectTopper.setFullName(subjectRs.getString("fullname"));
                        subjectTopper.setSubject(subjectRs.getString("subject"));
                        subjectTopper.setTotalMarks(subjectRs.getInt("subjectMark")); 
                        subjectTopperList.add(subjectTopper);
                    }
                }
            }
        }

        return subjectTopperList;
    }
}

