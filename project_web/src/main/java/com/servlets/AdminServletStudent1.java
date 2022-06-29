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
@WebServlet("/AdminServletStudent1")
public class AdminServletStudent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	AdminServices admin;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentId=request.getParameter("studentID");
		int id=Integer.parseInt(studentId);
		List<Course> course = admin.ViewCoursesByStudentId(id);
		for(int i=0;i<course.size();i++)
		{
			response.getWriter().print("Name : "+course.get(i).getName());
			response.getWriter().println();
			response.getWriter().print("Academic_year : "+course.get(i).getacademic_year());
			response.getWriter().println();
			response.getWriter().print("Grade : "+course.get(i).getGrade());
			response.getWriter().println();
		}
		
		//doGet(request, response);
	}

}
