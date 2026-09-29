package com.example.seatplan.controller;

public class SeatPlanResponse {

    private String examName;
    private String examDate;
    private String hallNumber;
    private String seatNumber;
    private String registerNumber;
    private String studentName;
    private String section;

    public SeatPlanResponse(String examName, String examDate,
                            String hallNumber, String seatNumber,
                            String registerNumber, String studentName,
                            String section) {

        this.examName = examName;
        this.examDate = examDate;
        this.hallNumber = hallNumber;
        this.seatNumber = seatNumber;
        this.registerNumber = registerNumber;
        this.studentName = studentName;
        this.section = section;
    }

    public String getExamName() {
        return examName;
    }

    public String getExamDate() {
        return examDate;
    }

    public String getHallNumber() {
        return hallNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSection() {
        return section;
    }
}