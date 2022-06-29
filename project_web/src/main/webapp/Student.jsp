<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>login student</h2>
	<form method="post" action="welcomServletStudent">
	<label for="username">Username</label>
    <input id="username" type="text" name = "username"/>
	<label for="password">Password</label>
	<input id="password" type="password" name="password"/>
	<input id="submit" value="submit" type="submit"/>
	</form>
</body>
</html>