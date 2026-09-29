package com.example.seatplan.controller;

import com.example.seatplan.entity.Exam;
import com.example.seatplan.entity.Hall;
import com.example.seatplan.entity.Seat;
import com.example.seatplan.entity.Student;
import com.example.seatplan.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private  SeatService seatService;


    // CREATE
    @PostMapping
    public Seat createSeat(@RequestBody SeatRequest request) {

        Seat seat = new Seat();

        seat.setSeatNumber(request.getSeatNumber());
        seat.setRowNumber(request.getRowNumber());
        seat.setColumnNumber(request.getColumnNumber());

        Hall hall = new Hall();
        hall.setId(request.getHallId());
        seat.setHall(hall);

        Student student = new Student();
        student.setId(request.getStudentId());
        seat.setStudent(student);

        Exam exam = new Exam();
        exam.setId(request.getExamId());
        seat.setExam(exam);

        return seatService.createSeat(seat);
    }

    // GET ALL
    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable Long id) {
        return seatService.getSeatById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Seat updateSeat(
            @PathVariable Long id,
            @RequestBody Seat seat) {

        return seatService.updateSeat(id, seat);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteSeat(@PathVariable Long id) {

        seatService.deleteSeat(id);

        return "Seat deleted successfully";
    }

    // FINAL SEAT PLAN
    @GetMapping("/plan")
    public List<SeatPlanResponse> getSeatPlan() {

        List<Seat> seats = seatService.getAllSeats();

        return seats.stream()
                .map(seat -> new SeatPlanResponse(
                        seat.getExam().getExamName(),
                        seat.getExam().getExamDate().toString(),
                        seat.getHall().getHallNumber(),
                        seat.getSeatNumber(),
                        seat.getStudent().getRegisterNumber(),
                        seat.getStudent().getName(),
                        seat.getStudent().getSection()
                ))
                .toList();
    }

    // Request class for creating a seat
    public static class SeatRequest {

        private String seatNumber;
        private int rowNumber;
        private int columnNumber;
        private Long hallId;
        private Long studentId;
        private Long examId;

        public String getSeatNumber() {
            return seatNumber;
        }

        public void setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public int getRowNumber() {
            return rowNumber;
        }

        public void setRowNumber(int rowNumber) {
            this.rowNumber = rowNumber;
        }

        public int getColumnNumber() {
            return columnNumber;
        }

        public void setColumnNumber(int columnNumber) {
            this.columnNumber = columnNumber;
        }

        public Long getHallId() {
            return hallId;
        }

        public void setHallId(Long hallId) {
            this.hallId = hallId;
        }

        public Long getStudentId() {
            return studentId;
        }

        public void setStudentId(Long studentId) {
            this.studentId = studentId;
        }

        public Long getExamId() {
            return examId;
        }

        public void setExamId(Long examId) {
            this.examId = examId;
        }
    }
}