<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Applications</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
<h1>University Admission System - Applications</h1>
	<table align="center">
		<tr>
			<th>Application ID</th>
			<th>Full Name</th>
			<th>Date of Birth</th>
			<th>Highest Qualification</th>
			<th>Marks Obtained</th>
			<th>Email</th>
			<th>Goals</th>
			<th>Scheduled Programme ID</th>
			<th>Status</th>
			<th>Date of Interview</th>
			<th></th>
		</tr>
		<c:forEach items="${appList}" var="appli">
			<form:form action="viewApplication.htm" method="post"
				modelAttribute="Application">
				<tr>
					<td><form:hidden path="applicationId"
							value="${appli.applicationId}" /> ${appli.applicationId}</td>
					<td><form:hidden path="fullName" value="${appli.fullName}" />${appli.fullName}</td>
					<td><form:hidden path="dateOfBirth"
							value="${appli.dateOfBirth}" />${appli.dateOfBirth}</td>
					<td><form:hidden path="highestQualification"
							value="${appli.highestQualification}" />${appli.highestQualification}</td>
					<td><form:hidden path="marksObtained"
							value="${appli.marksObtained}" />${appli.marksObtained}</td>
					<td><form:hidden path="email" value="${appli.email}" />${appli.email}</td>
					<td><form:hidden path="goals" value="${appli.goals}" />${appli.goals}</td>
					<td><form:hidden path="scheduledProgramId"
							value="${appli.scheduledProgramId}" />${appli.scheduledProgramId}</td>
					<td><form:hidden path="status" value="${appli.status}" />${appli.status}</td>
					<td><form:hidden path="dateOfInterview"
							value="${appli.dateOfInterview}" />${appli.dateOfInterview}</td>
					<td><input type="submit" value="View Application"></td>
				</tr>
			</form:form>
		</c:forEach>
	</table>
	<div id="footer">
		<a href="index.jsp">Home</a>
	</div>
</body>
</html>