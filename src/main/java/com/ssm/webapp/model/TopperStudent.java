package com.ssm.webapp.model;

public class TopperStudent {
    private String fullName;
    private String subject; 
    private int totalMarks;

    public TopperStudent() {
    }

    public TopperStudent(String fullName, String subject, int totalMarks) {
        this.fullName = fullName;
        this.subject = subject;
        this.totalMarks = totalMarks;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }
    
    @Override
    public String toString() {
        return "TopperStudent{" +
               "fullName='" + fullName + '\'' +
               ", subject='" + subject + '\'' +
               ", totalMarks=" + totalMarks +
               '}';
    }
}
