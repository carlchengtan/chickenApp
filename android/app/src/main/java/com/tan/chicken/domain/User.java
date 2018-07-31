package com.tan.chicken.domain;

import java.util.HashSet;
import java.util.Set;

public class User {

    private Long id;
    private String username;
    private String password;private
    Set<Chicken> chickens = new HashSet<>();
    private Set<Role> roles = new HashSet<Role>();

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

    public Set<Chicken> getChickens() {
        return chickens;
    }

    public void setChickens(Set<Chicken> chickens) {
        this.chickens = chickens;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
