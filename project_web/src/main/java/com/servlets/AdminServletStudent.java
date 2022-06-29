package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejbs.Admin;
import com.ejbs.Course;
import com.ejbs.MyBean;
import com.ejbs.Student;
import com.service.AdminServices;
import com.service.SingletonService;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/AdminServletStudent")
public class AdminServletStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	AdminServices admin;
    
    @EJB
    SingletonService s;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> student = s.viewAllStudents();
		for(int i=0;i<student.size();i++)
		{
			response.getWriter().print("Name : "+student.get(i).getUsername());
			response.getWriter().println();
			response.getWriter().print("Password : "+student.get(i).getPassword());
			response.getWriter().println();
			response.getWriter().print("Academic_year : "+student.get(i).getAcademic_year());
			response.getWriter().println();
			response.getWriter().print("Student_id : "+student.get(i).getStudent_id());
			response.getWriter().println();
			response.getWriter().print("Number_passed_courses : "+student.get(i).getNumber_passed_courses());
			response.getWriter().println();
			response.getWriter().print("List of Courses : ");
			for(int j=0;j<student.get(i).getList().size();j++)
			{
				response.getWriter().print(student.get(i).getList().get(j).getName());
				response.getWriter().println();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n=request.getParameter("username");
		String a=request.getParameter("academic_year");
		String no=request.getParameter("number_passed_courses");
		String c1id=request.getParameter("Course#1Id");
		String c1name=request.getParameter("Course#1Name");
		//String c2id=request.getParameter("Course#2Id");
		//String c2name=request.getParameter("Course#2Name");
		System.out.println(c1id);
		System.out.println(c1name);
		Course c1=new Course();
		c1.setId(Integer.parseInt(c1id));
		c1.setName(c1name);
		/*Course c2=new Course();
		c2.setId(Integer.parseInt(c2id));
		c2.setName(c2name);*/
		List<Course> c = new ArrayList<Course>();
		c.add(c1);
		//c.add(c2);
		Student student=new Student();
		student.setUsername(n);
		student.setAcademic_year(Integer.parseInt(a));
		student.setNumber_passed_courses(Integer.parseInt(no));
		student.setList(c);
		String q=admin.CreateStudent(student);
		response.getWriter().print(q);
		
		//doGet(request, response);
	}

}
