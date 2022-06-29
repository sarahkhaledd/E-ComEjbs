package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
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
import com.ejbs.Course2;
import com.ejbs.Student;
import com.ejbs.Stuff;
import com.ejbs.MyBean;
import java.util.Random;


@Stateless
@Path("/AdminService")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminServices {
	@PersistenceContext
    private EntityManager entityManager;
	@POST
	@Path("/CreateCourse")
	public String CreateCourse(Course course)
	{
		entityManager.persist(course);
		return "Course Added Successfully. ";
	}
	@POST
	@Path("/CreateCourse2")
	public String CreateCourse2(Course2 course)
	{
		entityManager.persist(course);
		return "Course Added Successfully. ";
	}
	@POST
	@Path("/CreateIDs/{id1}/{id2}")
	public String CreateIDs(@PathParam("id1")int id1,@PathParam("id2")int id2)//used to retrieve a parameter passed in through the URI
	{
		boolean done=false;
		TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);//createQuery method is used to create dynamic queries.
	  	List<Student> student = query.getResultList();
	  	for(int i=0;i<student.size();i++)
		{
	  		if(id1<=id2)
	  		{
	  			student.get(i).setStudent_id(id1);
		  		id1++;
		  		entityManager.merge(student.get(i));
		  		done=true;
	  		}
	  		else
	  		{
	  			done=false;
	  			return "false...";
	  		}
		}
	  	return "Done:)";
	}
	@POST
	@Path("/CreateStudent")
	public String CreateStudent(Student student)
	{
		String pwd = generateRandomPassword(8);
		student.setPassword(pwd);
		entityManager.persist(student);
		return "Student Added Successfully with passsword :  "+pwd;
	}
	
		public static String generateRandomPassword(int len) {
			String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
	          +"jklmnopqrstuvwxyz!@#$%&";
			Random rnd = new Random();
			StringBuilder sb = new StringBuilder(len);
			for (int i = 0; i < len; i++)
				sb.append(chars.charAt(rnd.nextInt(chars.length())));
			return sb.toString();
		}
	@POST
	@Path("/registerAsAdmin")
	public String register(Admin admin)
	{
		entityManager.persist(admin);
		return "Admin Added Successfully. ";
	}
	@POST
	@Path("/CreateStuff")
	public String CreateStuff(Stuff stuff)
	{
	  		entityManager.persist(stuff);
			return "Stuff Added Successfully. ";
	}
	@POST
	@Path("/loginAsAdmin")
	public boolean loginAsAdmin(Admin admin)
	{
		TypedQuery<Admin> query= entityManager.createQuery("SELECT s FROM Admin s WHERE s.username = :name AND s.password = :password", Admin.class);
		query.setParameter("name", admin.getUsername());
		query.setParameter("password", admin.getPassword());
		Admin admin1 = query.getSingleResult();
		if (admin1 != null ){
			return true;
          } else 
              return false;
          }
	@POST
	//@Path("/ViewCoursesByStudentId/{id}")
	@Path("/ViewCoursesByStudentId")
	//public List<Course> ViewCoursesByStudentId(@PathParam("id")int id)
	public List<Course> ViewCoursesByStudentId(int id)
	{
		TypedQuery<Student> query= entityManager.createQuery("SELECT s FROM Student s WHERE s.student_id = :id", Student.class);
		query.setParameter("id", id);
		Student student1 = query.getSingleResult();
		if (student1 != null){
			return student1.getList();
	      } else 
	          return null;
	      }
}
