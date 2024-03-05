package com.ssm.webapp.model;
import java.sql.Date;

public class AttendanceRecord {
    private int studentAttendanceId;
    private int studentId;
    private String studentName;
    private boolean period1;
    private boolean period2;
    private boolean period3;
    private boolean period4;
    private boolean period5;
    private Date attendanceDate;

    public AttendanceRecord() {
    }

    public int getStudentAttendanceId() {
        return studentAttendanceId;
    }

    public void setStudentAttendanceId(int studentAttendanceId) {
        this.studentAttendanceId = studentAttendanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isPeriod1() {
        return period1;
    }

    public void setPeriod1(boolean period1) {
        this.period1 = period1;
    }

    public boolean isPeriod2() {
        return period2;
    }

    public void setPeriod2(boolean period2) {
        this.period2 = period2;
    }

    public boolean isPeriod3() {
        return period3;
    }

    public void setPeriod3(boolean period3) {
        this.period3 = period3;
    }

    public boolean isPeriod4() {
        return period4;
    }

    public void setPeriod4(boolean period4) {
        this.period4 = period4;
    }

    public boolean isPeriod5() {
        return period5;
    }

    public void setPeriod5(boolean period5) {
        this.period5 = period5;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @Override
    public String toString() {
        return "AttendanceRecord{" +
                "studentAttendanceId=" + studentAttendanceId +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", period1=" + period1 +
                ", period2=" + period2 +
                ", period3=" + period3 +
                ", period4=" + period4 +
                ", period5=" + period5 +
                ", attendanceDate=" + attendanceDate +
                '}';
    }
}
