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
import com.ejbs.Course2;
import com.ejbs.MyBean;
import com.ejbs.Student;
import com.ejbs.Stuff;
import com.service.AdminServices;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/AdminServletStaff")
public class AdminServletStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	AdminServices admin;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n=request.getParameter("username");
		String p=request.getParameter("password");
		String c1id=request.getParameter("Course#1Id");
		String c1name=request.getParameter("Course#1Name");
		String c2id=request.getParameter("Course#2Id");
		String c2name=request.getParameter("Course#2Name");
		System.out.println(c1id);
		System.out.println(c1name);
		Course2 c1=new Course2();
		c1.setId(Integer.parseInt(c1id));
		c1.setName(c1name);
		Course2 c2=new Course2();
		c2.setId(Integer.parseInt(c2id));
		c2.setName(c2name);
		List<Course2> c = new ArrayList<Course2>();
		c.add(c1);
		c.add(c2);
		Stuff stuff=new Stuff();
		stuff.setUsername(n);
		stuff.setPassword(p);;
		stuff.setList(c);
		String q=admin.CreateStuff(stuff);
		response.getWriter().print(q);
		
		//doGet(request, response);
	}

}
