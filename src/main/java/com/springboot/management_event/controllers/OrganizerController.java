package com.springboot.management_event.controllers;


import com.springboot.management_event.model.dtos.EventOrganizerDTO;
import com.springboot.management_event.model.entities.User;
import com.springboot.management_event.repositories.UserRepository;
import com.springboot.management_event.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/organizer")
public class OrganizerController {

  private final OrganizerService service;
    @Autowired
    private UserRepository users;

    public OrganizerController(OrganizerService service) {
        this.service = service;
       // this.users = users;
    }

    @RequestMapping("/add")
    public String addOrganizator(@RequestBody EventOrganizerDTO eventOrganizer){
      // String userName = authentication.getName();

    //users.findByU
        service.addOrganizer(eventOrganizer.getEventId(), eventOrganizer.getUserId());

        return "Organizator added";
    }


}
