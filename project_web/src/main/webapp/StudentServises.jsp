<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>View Courses</h2>
	<form method="get" action="StudentServlet">
	<input id="submit" value="View All Courses" type="submit"/>
	</form>
	<h2>Register Course</h2>
	<form method="post" action="AdminServletCourse">
	<label for="id">ID</label>
    <input id="id" type="text" name = "id"/>
	<label for="nameCourse">Course Name</label>
	<input id="nameCourse" type="text" name="nameCourse"/>
	<label for="academic_year">Academic_year</label>
	<input id="academic_year" type="text" name="academic_year"/>
	<input id="submit" value="submit" type="submit"/>
	</form>
</body>
</html>