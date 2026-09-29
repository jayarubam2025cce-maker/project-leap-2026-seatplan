package com.example.seatplan.service;

import com.example.seatplan.entity.Hall;
import com.example.seatplan.repository.HallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {

    private final HallRepository hallRepository;

    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    // CREATE
    public Hall createHall(Hall hall) {
        return hallRepository.save(hall);
    }

    // GET ALL
    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    // GET BY ID
    public Hall getHallById(Long id) {
        return hallRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Hall updateHall(Long id, Hall hall) {

        Hall existingHall = hallRepository.findById(id).orElse(null);

        if (existingHall != null) {

            existingHall.setHallNumber(hall.getHallNumber());
            existingHall.setCapacity(hall.getCapacity());
            existingHall.setRows(hall.getRows());
            existingHall.setColumns(hall.getColumns());

            return hallRepository.save(existingHall);
        }

        return null;
    }

    // DELETE
    public void deleteHall(Long id) {
        hallRepository.deleteById(id);
    }
}