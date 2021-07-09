package com.springboot.management_event.controllers;

import javax.validation.Valid;

import com.springboot.management_event.model.entities.Account;
import org.springframework.web.bind.annotation.*;

import com.springboot.management_event.model.dtos.AccountCreate;
import com.springboot.management_event.model.dtos.AccountLogin;
import com.springboot.management_event.security.IdToken;
import com.springboot.management_event.services.AccountService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;
    public AccountController(AccountService service) {
        this.service = service;
    }
    @PostMapping
    public void create( @RequestBody AccountCreate inputs) {

        service.create(inputs);
    }
    @PostMapping("/login")
    public IdToken login(@Valid @RequestBody AccountLogin inputs) {
        return service.login(inputs);
    }

    @GetMapping("/ressource")
    public String getRessourceProtected() {
        return "my ressource protected !";
    }
    @GetMapping("/all_accounts")
    public List<Account> getAllAccounts() {
       return service.getAllAccounts();
    }








}
