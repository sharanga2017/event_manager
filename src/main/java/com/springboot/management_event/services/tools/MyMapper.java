package com.springboot.management_event.services.tools;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyMapper {

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}
