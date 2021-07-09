package com.springboot.management_event.controllers;

import com.springboot.management_event.model.dtos.AddRoleDTO;
import com.springboot.management_event.services.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.management_event.services.AccountService;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final AccountService service;
    public RoleController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/changerole")
    public String addRole(@RequestBody AddRoleDTO dto){

        String email = dto.getUsername();
        String role = dto.getRole();
        service.addRoleByUserName(email,role);

        return " Your role added";
    }


}
