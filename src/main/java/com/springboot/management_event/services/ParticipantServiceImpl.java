package com.springboot.management_event.services;

import com.springboot.management_event.model.entities.Account;
import com.springboot.management_event.model.entities.Event;
import com.springboot.management_event.model.entities.User;
import com.springboot.management_event.repositories.AccountRepository;
import com.springboot.management_event.repositories.EventRepository;
import com.springboot.management_event.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class ParticipantServiceImpl implements ParticipantService{



    private final EventRepository events;
    private final AccountRepository accounts;


    public ParticipantServiceImpl(EventRepository events, AccountRepository accounts) {
        this.accounts =accounts;
        this.events= events;

    }


    public void addByIdEvent(Long eventId, Long participantId){
       Account participant = accounts.findById(participantId).get();
       Event event = events.findById(eventId).get();



       events.save(event);



    }


}
