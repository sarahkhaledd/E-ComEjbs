package com.ejbs;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity//class is an entity.(creating table for this class in database)
public class Admin implements Serializable{// Serializable interface is required for entity classes that are accessed through a remote interface.
	
	@Id//primary key
	@GeneratedValue(strategy = GenerationType.AUTO)//JPA provider uses the database identity column to generate the primary key.
	int id;
	public String username;
	public String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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

}
