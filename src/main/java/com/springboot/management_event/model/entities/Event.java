package com.springboot.management_event.model.entities;



import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "events")
public class Event  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Status status;
    @OneToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxSeats;
    private int remainingSeats;
    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="event_user",
            joinColumns= @JoinColumn(name="event_id"),
            foreignKey = @ForeignKey(name = "user_event"),
            inverseJoinColumns = @JoinColumn(name="user_id",
                    foreignKey = @ForeignKey(name = "event_user"))

    )
    private Set<User> users = new HashSet<>();

    public void addUser(User user){
        this.users.add(user);
        user.getEvents().add(this);
    }

    public void removeAttendee(User user){
        this.users.remove(user);
        user.getEvents().remove(this);
    }



    @OneToOne
    @JoinColumn(name="speaker_id")
    private User speaker;



    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public User getSpeaker() {
        return speaker;
    }

    public void setSpeaker(User speaker) {
        this.speaker = speaker;
    }
}




