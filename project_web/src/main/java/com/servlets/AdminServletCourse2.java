package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
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
@WebServlet("/AdminServletCourse2")
public class AdminServletCourse2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	AdminServices admin;

    @EJB
    SingletonService s;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String i=request.getParameter("id");
		String n=request.getParameter("nameCourse");
		String a=request.getParameter("academic_year");
		Course2 c1 = new Course2();
		c1.setId(Integer.parseInt(i)+1);
		c1.setName(n);
		c1.setacademic_year(Integer.parseInt(a));
		String q1=admin.CreateCourse2(c1);
		response.getWriter().print(q1);
	}

}
