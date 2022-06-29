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
import com.service.AdminServices;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/welcomServlet")
public class welcomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	AdminServices admin;
    
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
		Admin ad=new Admin();
		ad.setUsername(n);
		ad.setPassword(p);
		boolean q=admin.loginAsAdmin(ad);
		if(q==true)
		{
			response.sendRedirect(request.getContextPath() + "/Admin.jsp");
		}
		else
		{
			response.getWriter().append(request.getContextPath() + "/NewFile.jsp");
		}
		
		//doGet(request, response);
	}

}
