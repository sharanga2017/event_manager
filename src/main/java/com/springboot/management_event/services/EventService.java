package com.springboot.management_event.services;

import com.springboot.management_event.model.dtos.EventCreate;
import com.springboot.management_event.model.dtos.EventView;
import com.springboot.management_event.model.entities.Event;

public interface EventService {

    void create(EventCreate event);

    EventView getByName(String name);
}
