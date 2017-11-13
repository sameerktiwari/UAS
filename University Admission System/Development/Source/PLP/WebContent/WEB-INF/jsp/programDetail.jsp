<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Program Scheduled</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h1>University Admission System - Programme Details</h1>
	<h2>Programs offered by the University</h2>
	<table align="center">
		<tr>
			<th>Program Name</th>
			<th>Description</th>
			<th>Applicant Eligibilty</th>
			<th>Duration</th>
			<th>Degree</th>
		</tr>
		<c:if test="${prog ne null}">
			<tr>
				<td>${prog.programName}</td>
				<td>${prog.description}</td>
				<td>${prog.applicantEligibility}</td>
				<td>${prog.duration}</td>
				<td>${prog.degree}</td>
			</tr>
			<tr>
				<td colspan="5"><a href="apply.htm?pId=${pId}"><button>Apply
							here</button></a></td>
			</tr>
		</c:if>

	</table>
	<div id="footer">
		<a href="index.jsp">Home</a>
	</div>
</body>
</html>