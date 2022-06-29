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
import com.service.AdminServices;
import com.service.StudentService;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/welcomServletStudent")
public class welcomServletStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	StudentService student;
    
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(mybean.getMsg());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n=request.getParameter("username");
		String p=request.getParameter("password");
		Student s=new Student();
		s.setUsername(n);
		s.setPassword(p);
		boolean q=student.loginAsStudent(s);
		if(q==true)
		{
			response.sendRedirect(request.getContextPath() + "/StudentServises.jsp");
		}
		else
		{
			response.getWriter().append(request.getContextPath() + "/Student.jsp");
		}
		
		//doGet(request, response);
	}

}
