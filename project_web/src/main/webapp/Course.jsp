<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="AdminServletCourse2">
    <input id="id" type="hidden" name = "id" value = <%out.println(request.getAttribute("id"));%>/>
	<input id="nameCourse" type="hidden" name="nameCourse" value = <%out.println(request.getAttribute("nameCourse"));%>/>
	<input id="academic_year" type="hidden" name="academic_year" value = <%out.println(request.getAttribute("academic_year"));%>/>
	<input id="submit" value="Are you sure?" type="submit"/>
	</form>
</body>
</html>