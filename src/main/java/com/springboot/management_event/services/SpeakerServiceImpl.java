package com.springboot.management_event.services;


import com.springboot.management_event.model.entities.Event;
import com.springboot.management_event.model.entities.User;
import com.springboot.management_event.repositories.EventRepository;
import com.springboot.management_event.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SpeakerServiceImpl implements SpeakerService {


    private final UserRepository users;

    private final EventRepository events;

    public SpeakerServiceImpl(UserRepository users, EventRepository events)
    {
        this.users = users;
        this.events = events;
    }

    @Override
    public void addByIdEvent(Long eventId, Long speakerId) {
        Event event = events.findById(eventId).get();

        User speaker = users.findById(speakerId).get();

        event.setSpeaker(speaker);

        events.save(event);

    }
}
