package com.springboot.management_event.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @JoinColumn(name = "role_id", nullable = false,
            foreignKey = @ForeignKey(name = "account_role"))
    @ManyToMany
    @JoinTable(name="account_role",
            joinColumns= @JoinColumn(name="account_id"),
            foreignKey = @ForeignKey(name = "role_account"),
            inverseJoinColumns = @JoinColumn(name="role_id",
                    foreignKey = @ForeignKey(name = "account_role"))

    )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role){
        this.roles.add(role);
       role.getAccounts().add(this);
    }



    public void removeRole(Role role){
        this.roles.remove(role);
        role.getAccounts().remove(this);
    }



    public List<String> getAllCodes() {

        List<String> listes = new ArrayList<>();
        for (Role role: roles
             ) {
           String code=  role.getCode();
            listes.add(code);
        }

        return listes;


    }

    public Account() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
