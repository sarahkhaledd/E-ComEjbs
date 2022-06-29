package com.ejbs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity//class is an entity.(creating table for this class in database)
public class Stuff implements Serializable{// Serializable interface is required for entity classes that are accessed through a remote interface.
	
	@Id//primary key
	@GeneratedValue(strategy = GenerationType.AUTO)//JPA provider uses the database identity column to generate the primary key.
	int id;
	String username;
	String password;
	@OneToMany(mappedBy="stuff", fetch = FetchType.EAGER)  //multiple courses instances can belong to a single student instance.
	//The mappedBy option is used because the order table actually doesn't contain a reference to customer
	List<Course2> list ;
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
	public List<Course2> getList() {
		return list;
	}
	public void setList(List<Course2> list) {
		this.list = list;
	} 
	
	
	

}
