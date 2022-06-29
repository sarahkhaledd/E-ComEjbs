package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejbs.Admin;
import com.ejbs.Course;
import com.ejbs.Course2;
import com.ejbs.MyBean;
import com.ejbs.Student;
import com.service.AdminServices;
import com.service.SingletonService;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/AdminServletCourse")
public class AdminServletCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	AdminServices admin;

    @EJB
    SingletonService s;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Course> course = s.viewAllCourses();
		for(int i=0;i<course.size();i++)
		{
			response.getWriter().print("Name : "+course.get(i).getName());
			response.getWriter().println();
			response.getWriter().print("Academic_year : "+course.get(i).getacademic_year());
			response.getWriter().println();
		}
		
		//return ContentService.createTextOutput(s.viewAllStudents())
		//return HtmlService.createHtmlOutput(s.viewAllStudents());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String i=request.getParameter("id");
		String n=request.getParameter("nameCourse");
		String a=request.getParameter("academic_year");
		Course c=new Course();
		//Course2 c1 = new Course2();
		c.setId(Integer.parseInt(i));
		c.setName(n);
		c.setacademic_year(Integer.parseInt(a));
		//c1.setId(Integer.parseInt(i)+4);
		//c1.setName(n);
		//c1.setacademic_year(Integer.parseInt(a));
		String q=admin.CreateCourse(c);
		//String q1=admin.CreateCourse2(c1);
		//response.getWriter().print(q);
		request.setAttribute("id", i);
		request.setAttribute("nameCourse", n);
		request.setAttribute("academic_year", a);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Course.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/Course2.jsp");
		//doGet(request, response);
	}

}
