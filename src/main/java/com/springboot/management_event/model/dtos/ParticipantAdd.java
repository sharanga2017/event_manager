package com.springboot.management_event.model.dtos;

public class ParticipantAdd {
    private Long eventId;
    private Long participantId;

    public ParticipantAdd() {

    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }
}
