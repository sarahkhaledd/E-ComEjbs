package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ejbs.Admin;
import com.ejbs.Course;
import com.ejbs.MyBean;
import com.ejbs.Student;

@Stateful
@Path("/StudentService")//the class with its own specific @Path value
@Produces(MediaType.APPLICATION_JSON)//defines the type of the response’s content that is returned by the service class or method
@Consumes(MediaType.APPLICATION_JSON)//defines the type of the request's content that is accepted by the service class or method.
public class StudentService {//implements MyServiceInterface
//the individual methods  with their own specific @Path value
	//@GET -> used to retrieve data.
	//@POST -> used to save or create data.
	@PersistenceContext
    private EntityManager entityManager;
	//@EJB//is injected into this bean
	//ArrayList<Course> courses = new ArrayList<Course>();
	Student s;
	public static String name;
	//MyBean bean;
	
	@POST
	@Path("/loginAsStudent")//TA!L2a#h
	public boolean loginAsStudent(Student student)//done
	{
		TypedQuery<Student> query= entityManager.createQuery("SELECT s FROM Student s WHERE s.username = :name AND s.password = :password", Student.class);
		query.setParameter("name", student.getUsername());
		query.setParameter("password", student.getPassword());
		Student student1 = query.getSingleResult();
			if (student1 != null){
					name=student1.getUsername();
			return true;
          } else 
              return false;
          }
	

	@GET
	@Path("/ViewCourses")
	public List<Course> ViewCourses()
	{
		TypedQuery<Student> query= entityManager.createQuery("SELECT s FROM Student s WHERE s.username = :name", Student.class);
		query.setParameter("name",name);
		Student student1 = query.getSingleResult();
		if (student1 != null){
			return student1.getList();
	      } else {
	    	  return null;
	      }
	          
	      }
	@POST
	@Path("/registerCourse")
	public String register(Course course)
	{
		TypedQuery<Student> query= entityManager.createQuery("SELECT s FROM Student s WHERE s.username = :name", Student.class);
		query.setParameter("name", name);
		Student student1 = query.getSingleResult();
		if(course.getacademic_year()==student1.getAcademic_year())
		{
			student1.getList().add(course);
			//entityManager.remove(arg0);
			entityManager.merge(student1);
			return "Registered Successfully. ";
		}
		System.out.println(Objects.nonNull(entityManager));
		return "fail. ";
	}

}