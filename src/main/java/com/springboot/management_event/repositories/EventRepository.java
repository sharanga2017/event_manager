package com.springboot.management_event.repositories;

import com.springboot.management_event.model.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    boolean existsByName(String value);
}
