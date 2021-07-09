package com.springboot.management_event.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
// @Secured("ROLE_ADMIN")
public class AdminController {

    @GetMapping("/admin-only")
    // @Secured({ "ROLE_ADMIN", "ROLE_BASIC" })
    @Secured("ROLE_USER")
    public String adminOnly() {
        return "I am an admin user!";
    }

    // Spel : Spring Expression Language
    @GetMapping("/admin-only-pre-authorize")
    // ROLE_ROOT = ROLE_ADMIN + ROLE_MANAGER
    // @Secured("ROLE_ROOT") Other solution
    @PreAuthorize("hasRole('ROLE_ADMIN') AND hasRole('ROLE_MANAGER')")
    public String adminOnlyPreAuthorize() {
        // String name = service.getSomething()
        return "I am an admin user! (PreAuthorize)";
    }
}