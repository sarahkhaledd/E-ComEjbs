package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ejbs.Admin;
import com.ejbs.Course;
import com.ejbs.Student;
import com.ejbs.Stuff;
import com.ejbs.MyBean;
import java.util.Random;


@Singleton
@Path("/SingletonService")//the class with its own specific @Path value
@Produces(MediaType.APPLICATION_JSON)//defines the type of the response’s content that is returned by the service class or method
@Consumes(MediaType.APPLICATION_JSON)//defines the type of the request's content that is accepted by the service class or method.
public class SingletonService {//implements MyServiceInterface
	@PersistenceContext
    private EntityManager entityManager;
	@GET
	@Path("/viewAllStudents")
	public List<Student> viewAllStudents()
	{
		TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);//createQuery method is used to create dynamic queries.
	  	List<Student> students = query.getResultList();

		  return students;
	      }
	@GET
	@Path("/viewAllCourses")
	public List<Course> viewAllCourses()
	{
		TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c", Course.class);//createQuery method is used to create dynamic queries.
	  	List<Course> courses = query.getResultList();

		  return courses;
	      }
}
