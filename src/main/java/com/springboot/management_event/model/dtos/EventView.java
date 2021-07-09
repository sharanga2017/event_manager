package com.springboot.management_event.model.dtos;

import com.springboot.management_event.model.entities.User;
import com.springboot.management_event.model.entities.Status;

import java.time.LocalDate;
import java.util.List;

public class EventView {

    private String name;
    private Status status;


    private LocalDate StartDate;
    private LocalDate EndDate;
    private int maxSeats;
    private int remainingSeats;

    private List<User> users;

    public EventView() {
    }


}
