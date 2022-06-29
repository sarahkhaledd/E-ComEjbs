package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ejbs.Admin;
import com.ejbs.Course;
import com.ejbs.Course2;
import com.ejbs.MyBean;
import com.ejbs.Student;
import com.ejbs.Stuff;

@Stateful
@Path("/StaffService")//the class with its own specific @Path value
@Produces(MediaType.APPLICATION_JSON)//defines the type of the response’s content that is returned by the service class or method
@Consumes(MediaType.APPLICATION_JSON)//defines the type of the request's content that is accepted by the service class or method.
public class StaffService {//implements MyServiceInterface
	@PersistenceContext
    private EntityManager entityManager;
	public static ArrayList<Student> students = new ArrayList<Student>();
	Stuff s;
	public static List<Course2> stuff_courses;
	//MyBean bean;
	
	@POST
	@Path("/loginAsStaff")
	public boolean loginAsStaff(Stuff stuff)//done
	{
		TypedQuery<Stuff> query= entityManager.createQuery("SELECT s FROM Stuff s WHERE s.username = :name AND s.password = :password", Stuff.class);
		query.setParameter("name", stuff.getUsername());
		query.setParameter("password", stuff.getPassword());
		Stuff stuff1 = query.getSingleResult();
				if (stuff1 != null ){
					//s=stuff;
					stuff_courses=stuff1.getList();
					System.out.println("dddddddddddddddddd"+query.getSingleResult().getList());
			return true;
          } else 
              return false;
          }

	@GET
	@Path("/ViewStudents")
	public List<Student> ViewStudents()
	{
		students.clear();
		TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);//createQuery method is used to create dynamic queries.
	  	List<Student> student = query.getResultList();
		for(int i=0;i<stuff_courses.size();i++)
		{
			for(int j=0;j<student.size();j++)
			{
				List<Course> c;
				c=student.get(j).getList();
				for(int k=0;k<c.size();k++)
				{
					if(c.get(k).getName().equals(stuff_courses.get(i).getName()))
					{
						students.add(student.get(j));
					}
				}
				//c.clear();
				
			}
		}
	       return students;
    }
	
	/*@PUT
	@Path("/AssignGrade")
	public String AssignGrade(@QueryParam("course_name")String course_name,@QueryParam("student_name")String student_name,@QueryParam("new_grade")double new_grade)
	*/
	@PUT
	@Path("/AssignGrade")
	public String AssignGrade(@QueryParam("course_name")String course_name,@QueryParam("student_name")String student_name,@QueryParam("new_grade")double new_grade)
	{
		Student student=new Student();
		System.out.println(students.size());
		for(int i=0;i<students.size();i++)
		{
			System.out.println(students.get(i).getUsername());
			System.out.println(student_name);
			System.out.println(course_name);
			System.out.println(new_grade);
			if(students.get(i).getUsername().equals(student_name))
			{
				List<Course> c;
				c=students.get(i).getList();
				System.out.println(c.size());
				for(int j=0;j<c.size();j++)
				{
					System.out.println(c.get(j).getName());
					System.out.println(course_name);
					if(c.get(j).getName().equals(course_name))
					{
						System.out.println(new_grade);
						c.get(j).setGrade(new_grade);
						student=students.get(i);
						entityManager.merge(student);
						return "Done....";
					}
				}
			}
		}
		return "fail...........";
		
    }
}