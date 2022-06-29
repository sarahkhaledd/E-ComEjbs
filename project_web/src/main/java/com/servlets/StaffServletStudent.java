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
import com.service.StaffService;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/StaffServletStudent")
public class StaffServletStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    StaffService staff;
    
    @EJB
    SingletonService s;
    
    public static ArrayList<Student> student= new ArrayList<Student>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		student.clear();
		student= (ArrayList<Student>) staff.ViewStudents();
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
				response.getWriter().print("Name : "+student.get(i).getList().get(j).getName());
				response.getWriter().println();
				response.getWriter().print("Academic_year : "+student.get(i).getList().get(j).getacademic_year());
				response.getWriter().println();
				response.getWriter().print("Grade : "+student.get(i).getList().get(j).getGrade());
				response.getWriter().println();
			}
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String c=request.getParameter("course_name");
		String n=request.getParameter("student_name");
		String g=request.getParameter("new_grade");
		String q=staff.AssignGrade(c, n, Double.parseDouble(g));
		response.getWriter().print(q);
	}

}
