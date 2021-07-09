package com.springboot.management_event.repositories;

import com.springboot.management_event.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<User, Long> {

}
