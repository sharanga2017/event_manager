package com.springboot.management_event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication

// @EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)

public class ManagementEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementEventApplication.class, args);
    }

}
