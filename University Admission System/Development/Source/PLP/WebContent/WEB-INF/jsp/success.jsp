<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h1>University Admission System - Application Submitted</h1>
	<h2>Your Application submitted successfully</h2>
	<h2 id="appId">Application ID: ${applicant.applicationId}</h2>
	<div id="footer">
		<a href="index.jsp">Home</a>
	</div>
</body>
</html>