package com.springboot.management_event.services;


import com.springboot.management_event.model.dtos.*;
import com.springboot.management_event.model.entities.*;
import com.springboot.management_event.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private final ModelMapper mapper;
    private final EventRepository events;
    private final AccountRepository accounts;
    public EventServiceImpl(ModelMapper mapper,
                            EventRepository events,
                            AccountRepository accounts
                            ) {
        this.mapper = mapper;
        this.events = events;
       this.accounts =accounts;
    }

    @Override
    public void create(EventCreate eventCreate) {
        Event event = new Event();
        event =  mapper.map(eventCreate, Event.class);
        event.setStatus(eventCreate.getStatusByIndex(eventCreate.getStatus()));
        events.save(event);
    }

    @Override
    public EventView getByName(String name) {


        return null;
    }






}
