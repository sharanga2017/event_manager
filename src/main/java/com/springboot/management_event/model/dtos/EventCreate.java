package com.springboot.management_event.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.management_event.model.entities.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventCreate {

    private String name;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate endDate;
    private int maxSeats;
    private int status;


    public Status getStatusByIndex(int status){


        Status x =null;
        switch (status){
            case 1 : x = Status.CREATED;
            break;
            case 2 : x = Status.IN_PROGRESS;
                break;
        }
        return x;
    }

    public EventCreate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
