package com.springboot.management_event.model.dtos;

public class AddRoleDTO {


    private String username;
    private String role;

    public AddRoleDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
