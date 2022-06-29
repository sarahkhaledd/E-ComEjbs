package com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejbs.Admin;
import com.ejbs.MyBean;
import com.ejbs.Student;
import com.ejbs.Stuff;
import com.service.AdminServices;
import com.service.StaffService;
import com.service.StudentService;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/welcomServletStaff")
public class welcomServletStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    StaffService staff;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n=request.getParameter("username");
		String p=request.getParameter("password");
		Stuff s=new Stuff();
		s.setUsername(n);
		s.setPassword(p);
		boolean q=staff.loginAsStaff(s);
		if(q==true)
		{
			response.sendRedirect(request.getContextPath() + "/StaffServises.jsp");
		}
		else
		{
			response.getWriter().append(request.getContextPath() + "/Staff.jsp");
		}
		
	}

}
