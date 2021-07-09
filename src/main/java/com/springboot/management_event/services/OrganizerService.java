package com.springboot.management_event.services;

import com.springboot.management_event.model.entities.User;

public interface OrganizerService {

    void addOrganizer(Long  eventId, Long userId);


}
