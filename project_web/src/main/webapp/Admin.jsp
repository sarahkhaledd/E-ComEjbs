<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Create Student</h2>
	<form method="post" action="AdminServletStudent">
	<label for="username">Username</label>
    <input id="username" type="text" name = "username"/>
	<label for="academic_year">Academic_year</label>
	<input id="academic_year" type="text" name="academic_year"/>
	<label for="number_passed_courses">Number_passed_courses</label>
	<input id="number_passed_courses" type="text" name="number_passed_courses"/>
	<label for="Course#1Id">Course#1 ID</label>
	<input id="Course#1Id" type="text" name="Course#1Id"/>
	<label for="Course#1Name">Course#1 Name</label>
	<input id="Course#1Name" type="text" name="Course#1Name"/>
	<input id="submit" value="submit" type="submit"/>
	</form>
	
	<h2>Create IDs</h2>
	<form method="post" action="AdminServletStudent2">
	<label for="id1">Range from : </label>
	<input id="id1" type="text" name="id1"/>
	<label for="id2">To : </label>
	<input id="id2" type="text" name="id2"/>
	<input id="submit" value="Create IDs" type="submit"/>
	</form>
	
	<h2>Create Staff</h2>
	<form method="post" action="AdminServletStaff">
	<label for="username">Username</label>
    <input id="username" type="text" name = "username"/>
	<label for="password">Password</label>
	<input id="password" type="password" name="password"/>
	<label for="Course#1Id">Course#1 ID</label>
	<input id="Course#1Id" type="text" name="Course#1Id"/>
	<label for="Course#1Name">Course#1 Name</label>
	<input id="Course#1Name" type="text" name="Course#1Name"/>
	<label for="Course#2Id">Course#2 ID</label>
	<input id="Course#2Id" type="text" name="Course#2Id"/><br>
	<label for="Course#2Name">Course#2 Name</label>
	<input id="Course#2Name" type="text" name="Course#2Name"/>
	<input id="submit" value="submit" type="submit"/>
	</form>
	<h2>Create Course</h2>
	<form method="post" action="AdminServletCourse">
	<label for="id">ID</label>
    <input id="id" type="text" name = "id"/>
	<label for="nameCourse">Course Name</label>
	<input id="nameCourse" type="text" name="nameCourse"/>
	<label for="academic_year">Academic_year</label>
	<input id="academic_year" type="text" name="academic_year"/>
	<input id="submit" value="submit" type="submit"/>
	</form>
	<h2>View Studenst Course by id</h2>
	<form method="post" action="AdminServletStudent1">
	<label for="studentID">Student ID : </label>
	<input id="studentID" type="text" name="studentID"/>
	<input id="submit" value="View Courses" type="submit"/>
	</form>
	<h2>View Studenst</h2>
	<form method="get" action="AdminServletStudent">
	<input id="submit" value="View All Students" type="submit"/>
	</form>
	<h2>View Courses</h2>
	<form method="get" action="AdminServletCourse">
	<input id="submit" value="View All Courses" type="submit"/>
	</form>
</body>
</html>