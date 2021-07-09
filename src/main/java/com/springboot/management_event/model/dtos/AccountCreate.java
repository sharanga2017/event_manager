package com.springboot.management_event.model.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.springboot.management_event.validation.MyEmail;
import com.springboot.management_event.validation.UniqueUsername;

public class AccountCreate {

    @Size(max = 255)
    @Email
    @UniqueUsername
    private String username;

    @NotBlank
    @Size(min = 8, max = 12)
    private String password;

    public AccountCreate() {
        //
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a string representation of this dto printing the username. The
     * implementation hides the password for security reasons.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
        return "AccountCreate [username=" + username + ", password=PROTECTED]";
    }
}
