package com.springboot.management_event.model.dtos;

import javax.validation.constraints.NotBlank;

public class AccountLogin {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public AccountLogin() {
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
