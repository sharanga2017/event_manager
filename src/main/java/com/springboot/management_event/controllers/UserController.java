package com.springboot.management_event.controllers;


import com.springboot.management_event.model.dtos.ParticipantAdd;
import com.springboot.management_event.model.dtos.UserAccountDTO;
import com.springboot.management_event.model.entities.Account;
import com.springboot.management_event.model.entities.Event;
import com.springboot.management_event.model.entities.User;
import com.springboot.management_event.repositories.AccountRepository;
import com.springboot.management_event.repositories.UserRepository;
import com.springboot.management_event.services.ParticipantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final ParticipantService service;

    @Autowired
    private UserRepository users;
    @Autowired
    private AccountRepository accounts;

    @Autowired
    private ModelMapper mapper;

    public UserController(ParticipantService service ) {
        this.service = service;

    }

    @PostMapping("/add/toaccount")
    public String addUserByIdToAccount(@Valid @RequestBody UserAccountDTO userAccount){
        User user = new User();

        user =  mapper.map(userAccount, User.class);
        Account account = accounts.findByUsername(userAccount.getEmail()).get();
         user.setAccount(account);
         users.save(user);
        return "User added to account";
    }

    @PostMapping("/add")
    public String  addUser(ParticipantAdd participant){
        service.addByIdEvent(participant.getEventId(), participant.getParticipantId());

        return "Participant added";
    }




}
