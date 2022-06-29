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
import com.service.Producer;
import com.service.SingletonService;
import com.service.StudentService;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	StudentService student;//DNs2$onO
    
    Producer producer;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Course> course = student.ViewCourses();
		for(int i=0;i<course.size();i++)
		{
			response.getWriter().print("Name : "+course.get(i).getName());
			response.getWriter().println();
			response.getWriter().print("Academic_year : "+course.get(i).getacademic_year());
			response.getWriter().println();
			response.getWriter().print("Grade : "+course.get(i).getGrade());
			response.getWriter().println();
		}
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String i=request.getParameter("id");
		String n=request.getParameter("nameCourse");
		String a=request.getParameter("academic_year");
		Course c=new Course();
		c.setId(Integer.parseInt(i));
		c.setName(n);
		c.setacademic_year(Integer.parseInt(a));
		String q=student.register(c);
		response.getWriter().print(q);
		//String q1=producer.services(c);
		//response.getWriter().print(q1);
	}

}
