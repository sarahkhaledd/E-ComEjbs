package com.ejbs;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity//class is an entity.(creating table for this class in database)
public class Course2 implements Serializable{// Serializable interface is required for entity classes that are accessed through a remote interface.
	
	@Id//primary key
	//@GeneratedValue(strategy = GenerationType.AUTO)//JPA provider uses the database identity column to generate the primary key.
	public int id;
	public String name;
	public int academic_year;
	public double grade;
	@ManyToOne
	@JoinColumn(name="id",insertable = false, updatable = false,nullable = false)//tells JPA which column to use when joining to the list of orders
	//table, in this example id of order.//Defines the column that JPA uses as the foreign key.
	@JsonbTransient
	Stuff stuff;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getacademic_year() {
		return academic_year;
	}
	public void setacademic_year(int academic_year) {
		this.academic_year = academic_year;
	}
	public Stuff getStuff() {
		return stuff;
	}
	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
