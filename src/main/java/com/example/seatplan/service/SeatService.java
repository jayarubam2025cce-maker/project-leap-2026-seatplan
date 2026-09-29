package com.example.seatplan.service;

import com.example.seatplan.entity.Seat;
import com.example.seatplan.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    // CREATE
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    // GET ALL
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    // GET BY ID
    public Seat getSeatById(Long id) {
        return seatRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Seat updateSeat(Long id, Seat seat) {

        Seat existingSeat = seatRepository.findById(id).orElse(null);

        if (existingSeat != null) {

            existingSeat.setSeatNumber(seat.getSeatNumber());
            existingSeat.setRowNumber(seat.getRowNumber());
            existingSeat.setColumnNumber(seat.getColumnNumber());
            existingSeat.setHall(seat.getHall());
            existingSeat.setStudent(seat.getStudent());
            existingSeat.setExam(seat.getExam());

            return seatRepository.save(existingSeat);
        }

        return null;
    }

    // DELETE
    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }
}