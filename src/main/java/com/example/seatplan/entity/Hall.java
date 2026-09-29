package com.example.seatplan.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "halls")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hall_number")
    private String hallNumber;

    @Column(name = "hall_capacity")
    private int capacity;

    @Column(name = "total_rows")
    private int rows;

    @Column(name = "total_columns")
    private int columns;

    public Hall() {
    }

    public Hall(String hallNumber, int capacity, int rows, int columns) {
        this.hallNumber = hallNumber;
        this.capacity = capacity;
        this.rows = rows;
        this.columns = columns;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(String hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}