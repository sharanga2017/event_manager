package com.springboot.management_event.model.dtos;

public class EventOrganizerDTO {

    private Long eventId;
    private Long userId;


    public EventOrganizerDTO() {

    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
