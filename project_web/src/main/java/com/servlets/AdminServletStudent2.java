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
@WebServlet("/AdminServletStudent2")
public class AdminServletStudent2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	AdminServices admin;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Id1=request.getParameter("id1");
		String Id2=request.getParameter("id2");
		int id1=Integer.parseInt(Id1);
		int id2=Integer.parseInt(Id2);
		String q= admin.CreateIDs(id1, id2);
		response.getWriter().print(q);
		//doGet(request, response);
	}

}
