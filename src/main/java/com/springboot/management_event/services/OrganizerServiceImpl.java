package com.springboot.management_event.services;

import com.springboot.management_event.model.entities.Event;
import com.springboot.management_event.model.entities.User;
import com.springboot.management_event.repositories.EventRepository;
import com.springboot.management_event.repositories.RoleRepository;
import com.springboot.management_event.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizerServiceImpl implements OrganizerService {


    private final EventRepository events;
    private final UserRepository users;
    private final RoleRepository roles;

    public OrganizerServiceImpl(EventRepository events, UserRepository users,
    RoleRepository roles) {
        this.users =users;
        this.events= events;
        this.roles = roles;

    }

    @Override
    public void addOrganizer(Long eventId, Long userId) {
        //find eventById
        Event event = events.findById(eventId).get();
        User user = users.findById(userId).get();

        event.addUser(user);

        user.getAccount().addRole(roles.findByCode("ROLE_ORGANIZER").get());
        events.save(event);


    }


}
