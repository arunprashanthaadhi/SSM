package com.ssm.webapp.model;

public class TimetableEntry {
    private int timetableId;
    private String day;
    private String period1, period2, period3, period4, period5, period6, period7;

    public TimetableEntry(int timetableId, String day, String period1, String period2, String period3, String period4, String period5, String period6, String period7) {
        this.timetableId = timetableId;
        this.day = day;
        this.period1 = period1;
        this.period2 = period2;
        this.period3 = period3;
        this.period4 = period4;
        this.period5 = period5;
        this.period6 = period6;
        this.period7 = period7;
    }

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPeriod1() {
        return period1;
    }

    public void setPeriod1(String period1) {
        this.period1 = period1;
    }

    public String getPeriod2() {
        return period2;
    }

    public void setPeriod2(String period2) {
        this.period2 = period2;
    }

    public String getPeriod3() {
        return period3;
    }

    public void setPeriod3(String period3) {
        this.period3 = period3;
    }

    public String getPeriod4() {
        return period4;
    }

    public void setPeriod4(String period4) {
        this.period4 = period4;
    }

    public String getPeriod5() {
        return period5;
    }

    public void setPeriod5(String period5) {
        this.period5 = period5;
    }

    public String getPeriod6() {
        return period6;
    }

    public void setPeriod6(String period6) {
        this.period6 = period6;
    }

    public String getPeriod7() {
        return period7;
    }

    public void setPeriod7(String period7) {
        this.period7 = period7;
    }
    
    @Override
    public String toString() {
        return "TimetableEntry{" +
                "timetableId=" + timetableId +
                ", day='" + day + '\'' +
                ", period1='" + period1 + '\'' +
                ", period2='" + period2 + '\'' +
                ", period3='" + period3 + '\'' +
                ", period4='" + period4 + '\'' +
                ", period5='" + period5 + '\'' +
                ", period6='" + period6 + '\'' +
                ", period7='" + period7 + '\'' +
                '}';
    }

}
