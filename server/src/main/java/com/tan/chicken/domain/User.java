package com.tan.chicken.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "account_user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    private String username;
    
    @JsonIgnore
    private String password;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "user")
	@JsonManagedReference
	private Set<Chicken> chickens = new HashSet<>();
	

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<Role>();

	
    public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, Set<Chicken> chickens, Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.chickens = chickens;
		this.roles = roles;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void addChicken(Chicken chicken){
    	this.chickens.add(chicken);
    }

    public Set<Chicken> getChickens() {
		return chickens;
	}

	public void setChickens(Set<Chicken> chickens) {
		this.chickens = chickens;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}