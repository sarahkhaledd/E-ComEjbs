package com.service;

import java.util.List;

import javax.ejb.Remote;

import com.ejbs.Course;
import com.ejbs.Student;
@Remote
public interface MyServiceInterface {
	
	public List<Course> ViewCourses();
	//public boolean loginAsStudent(Student student);
	

}
