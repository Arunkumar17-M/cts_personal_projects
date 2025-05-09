package com.cts.main.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String role;
	
	public UserDetails() {}

	public UserDetails(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

}
