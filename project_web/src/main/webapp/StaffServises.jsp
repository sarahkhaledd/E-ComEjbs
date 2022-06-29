<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>View Studenst</h2>
	<form method="get" action="StaffServletStudent">
	<input id="submit" value="View All Students" type="submit"/>
	</form>
	<h2>Assign Student Grade</h2>
	<form method="put" action="StaffServletStudent">
	<label for="course_name">Course Name</label>
    <input id="course_name" type="text" name = "course_name"/>
	<label for="student_name">Student Name</label>
	<input id="student_name" type="text" name="student_name"/>
	<label for="new_grade">New Grade</label>
	<input id="new_grade" type="text" name="new_grade"/>
	<input id="submit" value="Assign" type="submit"/>
	</form>
</body>	
</html>