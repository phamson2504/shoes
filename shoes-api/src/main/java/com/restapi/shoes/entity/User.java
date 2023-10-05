package com.restapi.shoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class User {
	@Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    
    private String email;
    
    private String address;
    
    private String password;

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
	public User() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User(Long id, String username, String email, String address, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.address = address;
		this.password = password;
	}
    
}
