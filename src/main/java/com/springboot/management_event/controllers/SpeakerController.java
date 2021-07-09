package com.springboot.management_event.controllers;

import com.springboot.management_event.model.dtos.SpeakerAdd;
import com.springboot.management_event.services.SpeakerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/speakers")
public class SpeakerController {

    private final SpeakerService service;

    public SpeakerController(SpeakerService service) {
        this.service = service;
    }

    @RequestMapping("/add")
    public void addByIdEvent(SpeakerAdd speaker){
       service.addByIdEvent(speaker.getEventId(), speaker.getSpeakerId());
    }
}
