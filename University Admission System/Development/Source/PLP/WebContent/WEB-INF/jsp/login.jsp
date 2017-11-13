<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
<h1>University Admission System- Login</h1>
<h2>Enter your LoginId and Password</h2>
<form:form action="validate.htm" method="post" modelAttribute="users">
<table align="center">
			<tr>
				<td>LoginId:</td>
				<td><form:input path="loginId" /> <form:errors path="loginId" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /> <form:errors path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
</table>
<form:hidden path="role" value="${users.role}"/>		
</form:form>
<div id="footer"><a href="index.jsp">Home</a></div>
</body>
</html>