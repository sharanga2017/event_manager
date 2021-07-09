package com.springboot.management_event.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {



    @OneToOne
    @JoinColumn(name="account_id",
            foreignKey = @ForeignKey(name = "user_account"))
    private Account account;
    @OneToOne
    @JoinColumn(name="address_id",
            foreignKey = @ForeignKey(name = "user_address"))
    private Address address;

    @ManyToMany(mappedBy = "users")
    private Set<Event> events = new HashSet<>();


    public User() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
