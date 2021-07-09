package com.springboot.management_event.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.management_event.validation.UniqueEmail;

import java.time.LocalDate;



public class UserAccountDTO {

    private String firstName;
    private String lastName;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;
    private String phone;
    private String companyName;
    @UniqueEmail
    private String email;

    public UserAccountDTO() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
