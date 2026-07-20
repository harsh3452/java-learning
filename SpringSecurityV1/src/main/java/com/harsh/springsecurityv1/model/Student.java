package com.harsh.springsecurityv1.model;

public class Student {
    private int studentId;
    private String studentName;
    private int studentMarks;

    public int getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(int studentMarks) {
        this.studentMarks = studentMarks;
    }

    public Student(){}

    public Student(int studentId,String studentName, int studentMarks){
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMarks = studentMarks;
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

}
