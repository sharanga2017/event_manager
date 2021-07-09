package com.springboot.management_event.model.dtos;

public class SpeakerAdd {

    private Long eventId;
    private Long speakerId;

    public SpeakerAdd() {

    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
    }
}
