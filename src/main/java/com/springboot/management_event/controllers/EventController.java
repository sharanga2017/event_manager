package com.springboot.management_event.controllers;


import com.springboot.management_event.model.dtos.EventCreate;
import com.springboot.management_event.model.dtos.EventView;
import com.springboot.management_event.model.dtos.ParticipantAdd;
import com.springboot.management_event.services.EventService;
import com.springboot.management_event.services.ParticipantService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService service;

    private final ParticipantService participantService;


    public EventController(EventService service,ParticipantService participantService )
    {
        this.service = service;
        this.participantService =participantService;
    }

    @GetMapping("/{name}")
    public EventView getByName(@PathVariable("name") String name)
    {
        return service.getByName(name);
    }

    @PostMapping("/add")
    public void create(@RequestBody EventCreate event ) {
        service.create(event);

    }


    @PostMapping("/add/participant")
    public String  addUser(ParticipantAdd participant){
        participantService.addByIdEvent(participant.getEventId(), participant.getParticipantId());

        return "Participant added";
    }


    /*
    @GetMapping("/user")
    public String getByName2(Authentication authentication)
    {
        return authentication.getName();
    }



     */

}
