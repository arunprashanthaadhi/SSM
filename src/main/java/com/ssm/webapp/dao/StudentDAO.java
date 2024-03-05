package com.ssm.webapp.dao;

import com.ssm.webapp.common.DatabaseConnection;
import com.ssm.webapp.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudentDetails() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT u.userid, smm.rollnumber, u.firstname, u.lastname, smm.english, smm.cs, smm.maths, smm.physics, smm.chemistry FROM user u JOIN studentmarksmapping smm ON u.userid = smm.studentid";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Student student = new Student();
                student.setUserId(rs.getInt("userid"));
                student.setRollNumber(rs.getInt("rollnumber"));
                student.setName(rs.getString("firstname") + " " + rs.getString("lastname"));
                student.setEnglish(rs.getInt("english"));
                student.setCs(rs.getInt("cs"));
                student.setMaths(rs.getInt("maths"));
                student.setPhysics(rs.getInt("physics"));
                student.setChemistry(rs.getInt("chemistry"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT u.userid, smm.rollnumber, u.firstname, u.lastname, smm.english, smm.cs, smm.maths, smm.physics, smm.chemistry FROM user u JOIN studentmarksmapping smm ON u.userid = smm.studentid";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Student student = new Student();
                student.setUserId(rs.getInt("userid"));
                student.setRollNumber(rs.getInt("rollnumber"));
                student.setName(rs.getString("firstname") + " " + rs.getString("lastname"));
                student.setEnglish(rs.getInt("english"));
                student.setCs(rs.getInt("cs"));
                student.setMaths(rs.getInt("maths"));
                student.setPhysics(rs.getInt("physics"));
                student.setChemistry(rs.getInt("chemistry"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public boolean deleteStudent(int userId) throws SQLException {
        String query = "DELETE FROM studentmarksmapping WHERE studentid = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }


    public Student getStudentById(int userId) throws SQLException {
        String query = "SELECT u.userid, u.username, u.firstname, u.lastname, u.dob, u.email, u.address, u.about, smm.rollnumber, smm.english, smm.cs, smm.maths, smm.physics, smm.chemistry FROM user u LEFT JOIN studentmarksmapping smm ON u.userid = smm.studentid WHERE u.userid = ?";
        Student student = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setUserId(rs.getInt("userid"));
                student.setRollNumber(rs.getInt("rollnumber"));
                student.setFirstName(rs.getString("firstname"));
                student.setLastName(rs.getString("lastname"));
                student.setDob(rs.getString("dob"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                student.setAbout(rs.getString("about"));
            }
        }
        return student;
    }

    public boolean updateStudent(Student student) throws SQLException {
        String sql = "UPDATE user SET firstname = ?, lastname = ?, dob = ?, email = ?, address = ?, about = ? WHERE userid = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getLastName());
            stmt.setString(3, student.getDob());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.getAddress());
            stmt.setString(6, student.getAbout());
            stmt.setInt(7, student.getUserId());
            System.out.println("Executing SQL query: " + stmt.toString());
System.out.println("stmt.executeUpdate()------>>>>>>>>>>"+stmt.executeUpdate());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }
    
    public List<Student> getStudentMarksByUsername(String username) {
        List<Student> studentList = new ArrayList<>();
        String query = "SELECT smm.*, u.* FROM studentmarksmapping AS smm JOIN user AS u ON smm.studentid = u.userid WHERE username = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setUserId(rs.getInt("userid"));
                    student.setRollNumber(rs.getInt("rollnumber"));
                    student.setName(rs.getString("firstname") + " " + rs.getString("lastname"));
                    student.setEnglish(rs.getInt("english"));
                    student.setCs(rs.getInt("cs"));
                    student.setMaths(rs.getInt("maths"));
                    student.setPhysics(rs.getInt("physics"));
                    student.setChemistry(rs.getInt("chemistry"));
                    studentList.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
    public List<Student> getStudentsByRollNumber(int rollNumber) {
        List<Student> studentList = new ArrayList<>();
        String query = "SELECT u.userid, smm.rollnumber, u.firstname, u.lastname, smm.english, smm.cs, smm.maths, smm.physics, smm.chemistry FROM user u JOIN studentmarksmapping smm ON u.userid = smm.studentid WHERE smm.rollnumber = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, rollNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setUserId(rs.getInt("userid"));
                    student.setRollNumber(rs.getInt("rollnumber"));
                    student.setName(rs.getString("firstname") + " " + rs.getString("lastname"));
                    student.setEnglish(rs.getInt("english"));
                    student.setCs(rs.getInt("cs"));
                    student.setMaths(rs.getInt("maths"));
                    student.setPhysics(rs.getInt("physics"));
                    student.setChemistry(rs.getInt("chemistry"));
                    studentList.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public boolean updateStudentMarks(int rollNumber, int englishMarks, int csMarks, int mathsMarks, int physicsMarks, int chemistryMarks) {
        String sql = "UPDATE studentmarksmapping SET english = ?, cs = ?, maths = ?, physics = ?, chemistry = ? WHERE rollnumber = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, englishMarks);
            stmt.setInt(2, csMarks);
            stmt.setInt(3, mathsMarks);
            stmt.setInt(4, physicsMarks);
            stmt.setInt(5, chemistryMarks);
            stmt.setInt(6, rollNumber);
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
