<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script><%@include file="/WEB-INF/js/validateDate.js" %></script>
</head>
<body>
	<h1>University Admission System - Application Form</h1>
	<h2>Enter your Details</h2>
	<form:form action="add.htm" method="post" modelAttribute="Application">
		<table align="center">
			<tr>
				<td>Full name:</td>
				<td><form:input path="fullName" pattern="[A-Za-z ]{2,}"
						required="required" title="Enter only alphabets" /> <form:errors
						path="fullName" /></td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td><form:input id="dateOfBirth" path="dateOfBirth"
						required="required" placeholder="yyyy-mm-dd"
						title="Enter valid Date of Birth" /> <form:errors
						path="dateOfBirth" /></td>
			</tr>
			<%-- <tr>
				<td>Highest Qualification:</td>
				<td><form:input path="highestQualification" required="required" />
					<form:errors path="highestQualification" /></td>
			</tr>  --%>

			<tr>
				<td>Highest Qualification</td>
				<td><form:select path="highestQualification" items="${domainlist}" required="required"></form:select></td>
			</tr>
			<tr>
				<td>Marks Obtained:</td>
				<td><form:input path="marksObtained" minValue="0"
						maxValue="100" required="required"
						title="Enter marks between 0 and 100" /> <form:errors
						path="marksObtained" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email"
						pattern="[A-Za-z0-9_.]{1,}[@][A-Za-z]{1,}[.]{1}[A-Za-z]{3}"
						required="required" title="Enter valid Emailid" /> <form:errors
						path="email" /></td>
			</tr>
			<tr>
				<td>Goals:</td>
				<td><form:input path="goals" required="required" /> <form:errors
						path="goals" /></td>
				<form:hidden path="status" value="Pending" />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit Details"
					onclick="return isBefore()"></td>
			</tr>
		</table>
		<form:hidden path="scheduledProgramId" value="${pId}" />
		<!-- msg = scheduledProgramId passed as ModelandView attribute -->
	</form:form>
	<div id="footer">
		<a href="index.jsp">Home</a>
	</div>
</body>
</html>